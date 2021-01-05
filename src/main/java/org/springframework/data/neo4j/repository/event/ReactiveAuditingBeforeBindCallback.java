/*
 * Copyright 2011-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.neo4j.repository.event;

import org.apiguardian.api.API;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.core.Ordered;
import org.springframework.data.auditing.ReactiveIsNewAwareAuditingHandler;
import org.springframework.data.mapping.callback.EntityCallback;

/**
 * Reactive {@link EntityCallback} to populate auditing related fields on an entity about to be bound to a record.
 *
 * @author Michael J. Simons
 * @soundtrack Iron Maiden - The Number Of The Beast
 * @deprecated since 6.0.2, please use {@link org.springframework.data.neo4j.core.mapping.callback.AuditingBeforeBindCallback}.
 */
@API(status = API.Status.DEPRECATED, since = "6.0")
@Deprecated
public final class ReactiveAuditingBeforeBindCallback implements ReactiveBeforeBindCallback<Object>, Ordered {

	private final org.springframework.data.neo4j.core.mapping.callback.ReactiveAuditingBeforeBindCallback delegate;

	public ReactiveAuditingBeforeBindCallback(ObjectFactory<ReactiveIsNewAwareAuditingHandler> auditingHandlerFactory) {

		this.delegate = new org.springframework.data.neo4j.core.mapping.callback.ReactiveAuditingBeforeBindCallback(
				auditingHandlerFactory);
	}

	@Override
	public Publisher<Object> onBeforeBind(Object entity) {
		return delegate.onBeforeBind(entity);
	}

	@Override
	public int getOrder() {
		return delegate.getOrder();
	}
}
