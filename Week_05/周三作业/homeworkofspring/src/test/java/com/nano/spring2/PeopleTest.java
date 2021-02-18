package com.nano.spring2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=PeopleConfig.class)
public class PeopleTest {


  @Autowired
  private People people;

  @Test
  public void play() {
    people.show();
  }

}