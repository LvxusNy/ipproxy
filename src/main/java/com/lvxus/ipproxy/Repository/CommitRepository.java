package com.lvxus.ipproxy.Repository;

import com.lvxus.ipproxy.Entity.CommitWorks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CommitRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int saveWorks(CommitWorks commitWorks) {
        return jdbcTemplate.update("insert into commit_works(id,WORKS,COMMITTIME,PASSTIME,SALARY,OWNERID) values (WORKSID_SEQ.nextval,?,?,?,?,?)",
                new Object[]{commitWorks.getWorks(),commitWorks.getCommitTime(),commitWorks.getPassTime(),commitWorks.getSalary(),commitWorks.getOwnerId()});
    }
}
