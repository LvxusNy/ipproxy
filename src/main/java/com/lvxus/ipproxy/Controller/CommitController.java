package com.lvxus.ipproxy.Controller;

import com.lvxus.ipproxy.Entity.CommitWorks;
import com.lvxus.ipproxy.Repository.CommitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CommitController {
    @Autowired
    private CommitRepository commitRepository;

    @PostMapping("/saveWorks")
    @ResponseBody
    public String saveWorks(@RequestBody CommitWorks commitWorks) {
        int result = commitRepository.saveWorks(commitWorks);
        if (result < 1) return "提交作品失败!!!";
        return "提交作品成功!!!";
    }


}
