package com.tuba.yuanyc.myokhttp.http;

import org.json.JSONObject;

/**
 * Author ：yuanyc
 * Time ：2017/6/9
 * Description ：
 */

public class JsonResponse extends DefaultHttpResponse {
    private JSONObject jsonObject;

    public JsonResponse(HttpResponse response) {
        super(response);
    }

    @Override
    protected void process() throws Throwable {
        String body = response.getString();
        jsonObject = new JSONObject(body);
    }

    /**
     * 获取返回的JSONObject数据
     * @return
     */
    public JSONObject getJson() {
        return jsonObject;
    }

}
