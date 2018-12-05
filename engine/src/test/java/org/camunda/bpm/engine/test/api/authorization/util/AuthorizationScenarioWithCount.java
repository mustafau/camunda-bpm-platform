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
package org.camunda.bpm.engine.test.api.authorization.util;


/**
 * @author Askar Akhmerov
 *
 */
public class AuthorizationScenarioWithCount extends AuthorizationScenario {
  protected long count;

  public static AuthorizationScenarioWithCount scenario() {
    return new AuthorizationScenarioWithCount();
  }

  public long getCount() {
    return count;
  }

  public void setCount(long count) {
    this.count = count;
  }

  public AuthorizationScenarioWithCount withCount(long instances) {
    this.setCount(instances);
    return this;
  }
}