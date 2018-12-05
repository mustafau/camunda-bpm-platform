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
package org.camunda.bpm.engine.rest.dto.identity;

import org.camunda.bpm.engine.identity.User;

/**
 * @author Daniel Meyer
 *
 */
public class UserCredentialsDto {

  protected String password;
  protected String authenticatedUserPassword;

  // transformers //////////////////////////////////

  public static UserCredentialsDto fromUser(User user) {
    UserCredentialsDto result = new UserCredentialsDto();
    result.setPassword(user.getPassword());
    return result;
  }

  // getters / setters /////////////////////////////

  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }

  public String getAuthenticatedUserPassword() {
    return authenticatedUserPassword;
  }
  public void setAuthenticatedUserPassword(String authenticatedUserPassword) {
    this.authenticatedUserPassword = authenticatedUserPassword;
  }

}