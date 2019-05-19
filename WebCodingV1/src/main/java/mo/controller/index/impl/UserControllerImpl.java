package mo.controller.index.impl;

import com.alibaba.fastjson.JSONObject;
import mo.controller.index.UserController;
import mo.core.Result;
import mo.core.ResultCode;
import mo.entity.po.User;
import mo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


import static mo.utils.StringValue.ONLINEJUDGE_SESSION_UER;

@RestController
@SessionAttributes(value = {ONLINEJUDGE_SESSION_UER}, types = {User.class})
public class UserControllerImpl implements UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserControllerImpl.class);

    @Resource
    private UserService userService;

    @Override
    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
    @ResponseBody
    public Result login(User user, HttpServletRequest request) {
        logger.info("user[{}]", user.toString());
        Result res = userService.checkLogin(user.getUsername(), user.getPasswd(), request.getSession());
        if (res.getCode() == ResultCode.OK.code()) {
            logger.info("登录成功，创建session，id为[{}],user[{}]", request.getSession().getId(), request.getSession().getAttribute("user"));
        }
        return res;
    }

    @Override
    @ResponseBody
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public Result logout(User user, SessionStatus sessionStatus) {
        logger.info("user[{}]", user.toString());
        sessionStatus.setComplete();
        return new Result().setCode(ResultCode.OK);
    }

    @Override
    @ResponseBody
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Result user(@RequestParam("username") String username) {
        JSONObject user = new JSONObject();
        user.put("user", userService.findUserByUsername(username));
        return new Result().setCode(ResultCode.OK).setData(user);
    }

    @Override
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Result register(@RequestBody User user, HttpServletRequest request) {
        logger.info("user[{}]", user.toString());
        Integer userId = userService.register(user, request.getSession());
        return null;
    }
}
