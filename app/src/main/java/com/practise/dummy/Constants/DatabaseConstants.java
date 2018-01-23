package com.practise.dummy.Constants;

/**
 * Created by win 8 pc on 12/29/2017.
 */

public class DatabaseConstants {

    public static final String DATABASE_NAME = "hot_&amp;_spice";


    public static final String VEG_SNACKS_TABLE = "veg_snacks_table";
    public static final String VEG_SNACKS_ID = "veg_snacks_id";
    public static final String VEG_SNACKS_Name = "veg_snacks_name";
    public static final String VEG_SNACKS_TYPE = "veg_snacks_type";
    public static final String VEG_SNACKS_PRICE = "veg_snacks_price";
    public static final String VEG_SNACKS_IMAGE_URL = "veg_snacks_image_url";
    public static final String VEG_SNACKS_TABLE_CREATE_SCRIPT = "create table if not exists "
            + VEG_SNACKS_TABLE + " ( " + VEG_SNACKS_ID + " Text, " + VEG_SNACKS_Name + " Text , " + VEG_SNACKS_TYPE + " Text, " + VEG_SNACKS_PRICE + " Text, " + VEG_SNACKS_IMAGE_URL +" Text);";

}
