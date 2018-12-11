package com.cowups.action;

import jodd.madvoc.meta.Action;
import jodd.madvoc.meta.In;
import jodd.madvoc.meta.MadvocAction;
import jodd.madvoc.meta.RestAction;
import jodd.madvoc.meta.method.DELETE;
import jodd.madvoc.meta.method.GET;
import jodd.madvoc.meta.method.POST;
import jodd.madvoc.meta.method.PUT;
import jodd.madvoc.result.JsonResult;
import jodd.madvoc.result.TextResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Author: Ma_guowei <605460575@qq.com>
 * @Date: 2018-10-24
 * @Description:
 **/
@MadvocAction("/test-api/v1/")
public class UserRestAction {

    @POST
    @RestAction("users")
    public JsonResult createNewUser() {
        return JsonResult.of("{\"code\":" + HttpServletResponse.SC_CREATED + ",\"message\":\"success\"}");
    }

    @DELETE
    @RestAction("users/{uid}")
    public JsonResult deleteUser(@In String uid) {
        return JsonResult.of("{\"code\":" + HttpServletResponse.SC_OK + ",\"message\":\"success\"}");
    }

    @PUT
    @RestAction("users/{uid}")
    public JsonResult updateUser() {
        return JsonResult.of("{\"code\":" + HttpServletResponse.SC_OK + ",\"message\":\"success\"}");
    }

    @GET
    @RestAction("users/{uid}")
    public JsonResult userList(@In String uid) {
        return JsonResult.of("{\"code\":" + HttpServletResponse.SC_OK + ",\"message\":\"success\"}");
    }

    @Deprecated
    @GET
    @RestAction("users/{uid}/blogs/{date}")
    public TextResult user(@In String uid, @In String date) {
        return TextResult.of("The user whose ID is :" + uid + ", and he or she has a blog written at " + date).asHtml();
    }

}
