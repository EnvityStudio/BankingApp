package com.hungtran.bankingassistant.util;

/**
 * Created by hungtd on 2/18/19.
 */

public class Constant {
    public static final String API_BASE_URL = "";
    public static final String LINKING_BANK_BASE_URL = "http://34.73.58.250:5000";
    public static final String GOOGLE_MAP_API_URL = "";
    public static final String TOKEN = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJ1c2VyX2lkIjowLCJ1c2VybmFtZSI6IjEiLCJjdXJyZW50X3RpbWUiOiIxNTUxODQ1NDE2ODAyIiwiZXhwIjoxNTYyMjEzNDE2fQ.0cHbZS1L_USZrigAxTLUacvTJR8HOuSwIORQ_btYDflHUCxZaKXk4KECPaM-qbLxY-VKsox2kBhAmSJAZDecgA";
    public static final String TOKEN_KEY = "TOKEN";
    public static final String ID_USER_KEY = "ID_USER_KEY";
    public static final Integer TYPE_SAVING_WITHDRAW = 0;
    public static final Integer TYPE_SAVING_WITHDRAW_AT_END_TERM = 1;
    public static final Integer TYPE_SAVING_MONTH = 0;
    public static final Integer TYPE_SAVING_YEAR = 1;
    public static final Integer TYPE_PRINCIPAL_BALANCE = 0;
    public static final Integer TYPE_PRINCIPAL_BALANCE_DECREASE = 1;
    public static final Integer TYPE_SAVING = 0;
    public static final Integer TYPE_LOAN = 1;
    public static final Integer TYPE_MONTH_0_RATE = 0;
    public static final Integer TYPE_MONTH_1_RATE = 1;
    public static final Integer TYPE_MONTH_2_RATE = 2;
    public static final Integer TYPE_MONTH_3_RATE = 3;
    public static final Integer TYPE_MONTH_6_RATE = 6;
    public static final Integer TYPE_MONTH_9_RATE = 9;
    public static final Integer TYPE_MONTH_12_RATE = 12;
    public static final Integer TYPE_MONTH_18_RATE = 18;
    public static final Integer TYPE_MONTH_24_RATE = 24;
    public static final Integer TYPE_MONTH_36_RATE = 36;
    public static final String PRIMARY_COLOR = "#187139";
    public static final String COLOR_UP = "#187139";
    public static final String COLOR_DOWN = "#bf1414";
    public static final String COLOR_UNCHANGE = "#000000";
    public static final int TYPE_SEARCH_LOCATION = 1;
    public static final int TYPE_SEARCH_AREA = 2;
    public static final int TYPE_SEARCH_KEY = 3;
    public static final String MY_BANK = "MY_BANK";
    public static final String BANK = "BANK";
    public static final String ID_BANK = "ID_BANK";
    public static final String DATA_ACCOUNT = "DATA_ACCOUNT";
    public static final int ID_VCB = 1;
    public static final int ID_BIDV = 2;
    public static final int ID_AGRI = 4;
    public static final int ID_VIETTIN = 15;

    public static final String MESSAGE = "MESSAGE";
    public static final String TRANSACTION_ID = "TRANSACTION_ID";

    /**
     * 1: atm - amt
     * 2 atm - saving
     * 3 saving - atm
     * 4 saving - saving
     * 5 linking
     */
    public static final int TRANSFER_ATM_ATM = 1;
    public static final int TRANSFER_ATM_SAVING = 2;
    public static final int TRANSFER_SAVING_ATM = 3;
    public static final int TRANSFER_SAVING_SAVING = 4;
    public static final int TRANSFER_LINKING = 5;
    public static final String TYPE_TRANSFER_MONEY = "TYPE_TRANSFER_MONEY";

    public static final String ERROR_OTP = "Mã OTP không hợp lệ hoặc đã hết hạn!";
    public static final String DIALOG = "DIALOG";
    public static final String PROGRESS = "PROGRESS_DIALOG";
    public static final String TRANSFER_MONEY = "TRANSFER_MONEY";
    public static final String RECEIVER_NAME = "RECEIVER_NAME";
    public static final String RECEIVER_BANK = "RECEIVER_BANK";
    public static final String RECEIVER_ACCOUNT = "RECEIVER_ACCOUNT";
    public static final String SAVING_TERM = "SAVING_TERM";
    public static final String SAVING_INTEREST_RATE = "SAVING_INTEREST_RATE";
    public static final String WITH_DRAW_ALL = "WITH_DRAW_ALL";
    public static final String ERROR_UNKNOWN = "Đã có lỗi Vui lòng thử lại!";
    public static final String REGISTER_ACCOUNT = "REGISTER_ACCOUNT";
    public static final String REGISTER_REQUEST = "REGISTER_REQUEST";
    public static String SAVING_ACCOUNT = "SAVING_ACCOUNT";
    public static String SAVING_FORMAT_DATE =  "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    public static String OTP_TYPE = "OTP_TYPE";

    // TRANSFER
    public static int OTP_NORMAL = 0;
    public static int OTP_REGISTER = 1;
    public static int OTP_CHANGE_PASSWORD = 2;
    public static int OTP_FORGOT_PASSWORD = 3;


}
