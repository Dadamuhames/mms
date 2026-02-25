package com.uzum.mms.constant;


import org.springframework.beans.factory.annotation.Value;

public class Constants {
    public final static int feeAmount = 1;

    @Value(value = "${url.cms}")
    public static String cmsUrl;

    @Value(value = "${url.coreLedger}")
    public static String coreLedgerUrl;


    public static final int MAX_PAGE_SIZE = 10;

}
