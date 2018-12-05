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
package org.camunda.bpm.engine.impl.jobexecutor;

import org.camunda.bpm.engine.impl.interceptor.CommandContext;
import org.camunda.bpm.engine.impl.jobexecutor.ProcessEventJobHandler.EventSubscriptionJobConfiguration;
import org.camunda.bpm.engine.impl.persistence.entity.EventSubscriptionEntity;
import org.camunda.bpm.engine.impl.persistence.entity.ExecutionEntity;
import org.camunda.bpm.engine.impl.persistence.entity.JobEntity;


/**
 * @author Daniel Meyer
 */
public class ProcessEventJobHandler implements JobHandler<EventSubscriptionJobConfiguration> {

  public final static String TYPE = "event";

  public String getType() {
    return TYPE;
  }

  public void execute(EventSubscriptionJobConfiguration configuration, ExecutionEntity execution, CommandContext commandContext, String tenantId) {
    // lookup subscription:
    String eventSubscriptionId = configuration.getEventSubscriptionId();
    EventSubscriptionEntity eventSubscription = commandContext.getEventSubscriptionManager()
      .findEventSubscriptionById(eventSubscriptionId);

    // if event subscription is null, ignore
    if(eventSubscription != null) {
      eventSubscription.eventReceived(null, false);
    }

  }

  @Override
  public EventSubscriptionJobConfiguration newConfiguration(String canonicalString) {
    return new EventSubscriptionJobConfiguration(canonicalString);
  }

  public static class EventSubscriptionJobConfiguration implements JobHandlerConfiguration {

    protected String eventSubscriptionId;

    public EventSubscriptionJobConfiguration(String eventSubscriptionId) {
      this.eventSubscriptionId = eventSubscriptionId;
    }

    public String getEventSubscriptionId() {
      return eventSubscriptionId;
    }

    @Override
    public String toCanonicalString() {
      return eventSubscriptionId;
    }

  }

  public void onDelete(EventSubscriptionJobConfiguration configuration, JobEntity jobEntity) {
    // do nothing
  }

}