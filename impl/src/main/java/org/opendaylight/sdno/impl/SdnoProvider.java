/*
 * Copyright © 2017 HPE. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.sdno.impl;

import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.sal.binding.api.BindingAwareBroker.RpcRegistration;
import org.opendaylight.controller.sal.binding.api.RpcProviderRegistry;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdno.rev150105.SdnoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SdnoProvider {

    private static final Logger LOG = LoggerFactory.getLogger(SdnoProvider.class);
    private RpcRegistration<SdnoService> serviceRegistration;
    private RpcProviderRegistry rpcProviderRegistry;

    private final DataBroker dataBroker;

    public SdnoProvider(final DataBroker dataBroker, RpcProviderRegistry rpcRegistry) {
        this.dataBroker = dataBroker;
        this.rpcProviderRegistry = rpcRegistry;
    }

    /**
     * Method called when the blueprint container is created.
     */
    public void init() {
        LOG.info("SdnoProvider Session Initiated,hahaha....");
        serviceRegistration = rpcProviderRegistry.addRpcImplementation(SdnoService.class, new SdnoProviderImpl());
    }

    /**
     * Method called when the blueprint container is destroyed.
     */
    public void close() {
        LOG.info("SdnoProvider Closed");
        serviceRegistration.close();
    }


}