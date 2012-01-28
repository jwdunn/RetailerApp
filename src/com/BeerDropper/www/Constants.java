package com.BeerDropper.www;

import android.provider.BaseColumns;



/**
 * List for string constants that are used for database related classes 
 * 
 */
public interface Constants extends BaseColumns {
    public static final String TABLE_NAME = "localhistory";

    // Everything Stored in the DB
	public static final String C_DISTRIBUTOR = "distributor_id";
	public static final String C_NAME = "user_name";
	public static final String C_ADDRESS = "user_address";
	public static final String C_DESCRIPTION = "order_descr";
	public static final String C_PHONE = "user_phone";
	public static final String C_STATUS = "order_status";
	public static final String C_COMPLETE = "order_complete";
	public static final String C_CANCEL = "order_cancel";

}	

