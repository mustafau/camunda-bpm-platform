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
package org.camunda.bpm.engine.impl.form.validator;

import org.camunda.bpm.engine.impl.form.FormException;

/**
 * @author Thomas Skjolberg
 */
public class FormFieldConfigurationException extends FormException {

  private static final long serialVersionUID = 1L;

  protected String configuration;

  public FormFieldConfigurationException(String configuration) {
    super();

    this.configuration = configuration;
  }

  public FormFieldConfigurationException(String configuration, String message, Throwable cause) {
    super(message, cause);

    this.configuration = configuration;
  }

  public FormFieldConfigurationException(String configuration, String message) {
    super(message);

    this.configuration = configuration;
  }

  public FormFieldConfigurationException(String configuration, Throwable cause) {
    super(cause);

    this.configuration = configuration;
  }

  public String getConfiguration() {
    return configuration;
  }

}