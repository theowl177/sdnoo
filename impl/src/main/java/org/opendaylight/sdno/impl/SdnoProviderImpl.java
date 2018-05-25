package org.opendaylight.sdno.impl;

import java.util.concurrent.Future;

import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdno.rev150105.HelloWorldInput;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdno.rev150105.HelloWorldOutput;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdno.rev150105.HelloWorldOutputBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sdno.rev150105.SdnoService;
import org.opendaylight.yangtools.yang.common.RpcResult;
import org.opendaylight.yangtools.yang.common.RpcResultBuilder;

public class SdnoProviderImpl implements SdnoService {

    @Override
    public Future<RpcResult<HelloWorldOutput>> helloWorld(HelloWorldInput input) {
        HelloWorldOutputBuilder helloWorldOutputBuilder = new HelloWorldOutputBuilder();
        helloWorldOutputBuilder.setGreating("Welcome to ODL: " +input.getName());

        return RpcResultBuilder.success(helloWorldOutputBuilder.build()).buildFuture();
    }

}
