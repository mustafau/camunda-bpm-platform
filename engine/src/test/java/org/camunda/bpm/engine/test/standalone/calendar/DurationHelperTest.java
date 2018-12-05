/*
 * Copyright © 2012 - 2018 camunda services GmbH and various authors (info@camunda.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.bpm.engine.test.standalone.calendar;

import static junit.framework.Assert.assertNull;
import static junit.framework.TestCase.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.camunda.bpm.engine.impl.calendar.DurationHelper;
import org.camunda.bpm.engine.impl.util.ClockUtil;
import org.junit.AfterClass;
import org.junit.Test;

public class DurationHelperTest {

  @Test
  public void shouldNotExceedNumber() throws Exception {
    ClockUtil.setCurrentTime(new Date(0));
    DurationHelper dh = new DurationHelper("R2/PT10S");

    ClockUtil.setCurrentTime(new Date(15000));
    assertEquals(20000, dh.getDateAfter().getTime());


    ClockUtil.setCurrentTime(new Date(30000));
    assertNull(dh.getDateAfter());
  }

  @Test
  public void shouldNotExceedNumberPeriods() throws Exception {
    ClockUtil.setCurrentTime(parse("19700101-00:00:00"));
    DurationHelper dh = new DurationHelper("R2/1970-01-01T00:00:00/1970-01-01T00:00:10");

    ClockUtil.setCurrentTime(parse("19700101-00:00:15"));
    assertEquals(parse("19700101-00:00:20"), dh.getDateAfter());


    ClockUtil.setCurrentTime(parse("19700101-00:00:30"));
    assertNull(dh.getDateAfter());
  }

  @Test
  public void shouldNotExceedNumberNegative() throws Exception {
    ClockUtil.setCurrentTime(parse("19700101-00:00:00"));
    DurationHelper dh = new DurationHelper("R2/PT10S/1970-01-01T00:00:50");

    ClockUtil.setCurrentTime(parse("19700101-00:00:20"));
    assertEquals(parse("19700101-00:00:30"), dh.getDateAfter());


    ClockUtil.setCurrentTime(parse("19700101-00:00:35"));

    assertEquals(parse("19700101-00:00:40"), dh.getDateAfter());
  }


  @AfterClass
  public static void resetTime() {
    ClockUtil.reset();
  }

  private Date parse(String str) throws Exception {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd-HH:mm:ss");
    return simpleDateFormat.parse(str);
  }


}