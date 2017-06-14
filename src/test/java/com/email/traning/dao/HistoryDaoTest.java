package com.email.traning.dao;

import com.email.traning.domain.model.History;
import com.email.traning.domain.model.Statuses;
import com.email.traning.domain.real.HistoryReal;
import com.email.traning.domain.real.OrderReal;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static junit.framework.TestCase.assertNotNull;

/**
 * Created by Smeet on 14.06.2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HistoryDaoTest {

    @Autowired
    private HistoryDao historyDao;
    private Long historyId;
    private History history;

    @Before
    public void createHistory() {
        history = new HistoryReal(LocalDate.now(), "description here", new OrderReal(), Statuses.FINISHED);
        historyDao.create(history);
        this.historyId = history.getId();
        assertNotNull("History id is null", historyId);
        System.out.println("History with id " + historyId + " added");
    }

    @After
    public void removeHistory() {
        assertNotNull("Object from db not removed", historyDao.remove(historyId));
        System.out.println("Removed");
    }
    @Test
    public void Test() {
        History history = historyDao.getById(historyId);
        assertNotNull("Object from db id null", history);

    }

}
