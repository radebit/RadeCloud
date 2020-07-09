package com.radebit.springcloud.controller;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.afs.model.v20180112.AuthenticateSigRequest;
import com.aliyuncs.afs.model.v20180112.AuthenticateSigResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Rade
 * @date 2020/7/8 8:05 下午
 * @url https://blog.radebit.com
 * 说明：
 */
@RequestMapping("/ali")
@Controller
public class TestController {

    String regionid = "cn-hangzhou";
    String accessKeyId = "";
    String accessKeySecret = "";

    IClientProfile profile = DefaultProfile.getProfile(regionid, accessKeyId, accessKeySecret);
    IAcsClient client = new DefaultAcsClient(profile);

    @PostMapping("/check")
    public void testProfile(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws ClientException {
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", "afs", "afs.aliyuncs.com");
        AuthenticateSigRequest request = new AuthenticateSigRequest();
        request.setSessionId(httpRequest.getParameter("sessionId"));// 会话ID。必填参数，从前端获取，不可更改。
        request.setSig(httpRequest.getParameter("sgi"));// 签名串。必填参数，从前端获取，不可更改。
        request.setToken(httpRequest.getParameter("token"));// 请求唯一标识。必填参数，从前端获取，不可更改。
        request.setScene("nc_login");// 场景标识。必填参数，从前端获取，不可更改。
        request.setAppKey("FFFF0N00000000009418");// 应用类型标识。必填参数，后端填写。
        request.setRemoteIp("124.160.107.91");// 客户端IP。必填参数，后端填写。
        try {
            //response的code枚举：100验签通过，900验签失败
            AuthenticateSigResponse response = client.getAcsResponse(request);

            if (response.getCode() == 100) {
                System.out.println("验签通过");
                httpResponse.sendRedirect("/?state=0");
            } else {
                System.out.println("验签失败");
                httpResponse.sendRedirect("/?state=-1");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @GetMapping("/")
    public String testTest() {
        return "index";
    }
}
