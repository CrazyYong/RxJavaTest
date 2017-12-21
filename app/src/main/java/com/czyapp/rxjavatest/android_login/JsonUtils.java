package com.czyapp.rxjavatest.android_login;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by luoliwen on 16/5/31.
 */
public class JsonUtils {
    /**
     * @param json
     * @return
     */
    public static boolean parserJson(String json) {
        boolean flag = false;
        try{
            int result = new JSONObject(json).getJSONObject("result").getInt("resultCode");
            if (result!=1){
                flag = false;
            }else{
                flag = true;
            }
        }catch(JSONException e){
           e.printStackTrace();
        }

        return flag;
    }
}
