package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.service.UsersService;
import com.utils.R;

import java.util.Map;

@RestController
@RequestMapping("userAnalysis")
public class UserAnalysisController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/getUserCountByRole")
    public R getUserCountByRole() {
        Map<String, Integer> userCountByRole = usersService.getUserCountByRole();
        return R.ok().put("data", userCountByRole);
    }
}