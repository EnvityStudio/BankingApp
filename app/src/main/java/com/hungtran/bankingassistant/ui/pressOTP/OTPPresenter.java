package com.hungtran.bankingassistant.ui.pressOTP;

import android.content.Context;
import android.util.Log;

import com.hungtran.bankingassistant.model.base.BaseResponse;
import com.hungtran.bankingassistant.model.error.AppError;
import com.hungtran.bankingassistant.model.error.AppErrors;
import com.hungtran.bankingassistant.model.interestRate.InterestRateByBank;
import com.hungtran.bankingassistant.model.interestRate.InterestRateResponse;
import com.hungtran.bankingassistant.model.otp.OTPModel;
import com.hungtran.bankingassistant.model.otp.OTPModelRequest;
import com.hungtran.bankingassistant.model.register.RegisterRequest;
import com.hungtran.bankingassistant.network.ServiceGenerator;
import com.hungtran.bankingassistant.util.Constant;
import com.hungtran.bankingassistant.util.base.SharePreference;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

import static android.support.constraint.Constraints.TAG;

public class OTPPresenter implements OTPContract.Presenter {

    private OTPContract.View mView;

    private Context mContext;

    public OTPPresenter(OTPContract.View mView, Context mContext) {
        this.mView = mView;
        this.mContext = mContext;
    }

    @Override
    public void submitOTP(int transactionId, int OTP) {
        OTPModel otpModel = new OTPModel(OTP, transactionId);
        OTPModelRequest otpModelRequest = new OTPModelRequest(otpModel);
        submitOTPObserverable(otpModelRequest).subscribeWith(submitOTPObserver());
    }

    @Override
    public void registerAccount(RegisterRequest registerRequest) {
        registerObsererable(registerRequest).subscribeWith(registerObserver());
    }

    @Override
    public void changePassword(RegisterRequest registerRequest) {
        changePasswordObservable(registerRequest).subscribeWith(changePasswordObserver());
    }

    @Override
    public void forgotPassword(RegisterRequest registerRequest) {
        forgotPasswordObservable(registerRequest).subscribeWith(forgotPasswordObserver());
    }

    private Observable<BaseResponse> forgotPasswordObservable(RegisterRequest registerRequest){
        return ServiceGenerator.resquest().forgotPasswordSubmit(SharePreference.getStringVal(Constant.TOKEN_KEY), registerRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private DisposableObserver<BaseResponse> forgotPasswordObserver(){
        return  new DisposableObserver<BaseResponse>() {
            @Override
            public void onNext(BaseResponse response) {
                mView.changePasswordSuccess();
            }

            @Override
            public void onError(Throwable e) {
                String message = AppError.mapError(e);
                mView.changePasswordFail(message);
                mView.hideProgressBar();
            }

            @Override
            public void onComplete() {
                mView.hideProgressBar();
            }
        };
    }

    private Observable<BaseResponse> changePasswordObservable(RegisterRequest registerRequest){
        return ServiceGenerator.resquest().changePassword(SharePreference.getStringVal(Constant.TOKEN_KEY), registerRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private DisposableObserver<BaseResponse> changePasswordObserver(){
        return  new DisposableObserver<BaseResponse>() {
            @Override
            public void onNext(BaseResponse response) {
                mView.changePasswordSuccess();
            }

            @Override
            public void onError(Throwable e) {
                String message = AppError.mapError(e);
                mView.changePasswordFail(message);
                mView.hideProgressBar();
            }

            @Override
            public void onComplete() {
                mView.hideProgressBar();
            }
        };
    }


    private Observable<retrofit2.Response<Void>> registerObsererable(RegisterRequest registerRequest){
        return ServiceGenerator.resquest()
                .registerAccount(registerRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private DisposableObserver<retrofit2.Response<Void>> registerObserver() {
        return new DisposableObserver<retrofit2.Response<Void>>() {

            @Override
            public void onNext(Response<Void> voidResponse) {
                mView.registerSuccess();
            }

            @Override
            public void onError(Throwable e) {
                AppErrors appErrors = AppError.mapAppErrors(e);
                String errorMessage = AppError.mapFirstError(appErrors);
                mView.registerFail(errorMessage);
                mView.hideProgressBar();
            }

            @Override
            public void onComplete() {
                mView.hideProgressBar();
            }
        };
    }




    private Observable<retrofit2.Response<Void>> submitOTPObserverable(OTPModelRequest otpModel) {
        return ServiceGenerator.resquest()
                .submitOTP(SharePreference.getStringVal(Constant.TOKEN_KEY), otpModel)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private DisposableObserver<retrofit2.Response<Void>> submitOTPObserver() {
        return new DisposableObserver<retrofit2.Response<Void>>() {
            @Override
            public void onNext(retrofit2.Response<Void> response) {
                if (response.code() == 200) {
                    mView.submitOTPSuccess();
                } else {
                    mView.submitOTPFail(Constant.ERROR_OTP);
                }
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: " + e.getMessage());
                mView.hideProgressBar();
            }

            @Override
            public void onComplete() {
                mView.hideProgressBar();
            }
        };
    }
}
