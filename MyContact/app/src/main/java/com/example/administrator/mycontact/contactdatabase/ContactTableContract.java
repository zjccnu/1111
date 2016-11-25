package com.example.administrator.mycontact.contactdatabase;

import android.provider.BaseColumns;

/**
 *
 * Created by Administrator on 2016/8/18.
 *
 */
public class ContactTableContract {
  public static class  ContactTableEntry implements BaseColumns{
      public static String TBNAME = "contact123";
      public static String NAME_ENTRY = "name";
      public static String PHONE_ENTRY = "phone";
      public static String QQ_ENTRY = "qq_number";
  }
}
