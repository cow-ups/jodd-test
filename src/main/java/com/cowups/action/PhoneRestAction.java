package com.cowups.action;

import jodd.madvoc.meta.In;
import jodd.madvoc.meta.MadvocAction;
import jodd.madvoc.meta.method.GET;
import jodd.madvoc.result.TextResult;

/**
 * @Author: Ma_guowei <605460575@qq.com>
 * @Date: 2018-10-24
 * @Description:
 **/
@MadvocAction("/test-api/v1/")
public class PhoneRestAction {

    @GET @jodd.madvoc.meta.RestAction("authors/{phone}")
    public TextResult author(@In String phone){
        return TextResult.of("The author's phone number is: " + phone).asHtml();
    }

}
