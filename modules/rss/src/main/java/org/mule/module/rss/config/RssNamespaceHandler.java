/*
 * $Id$
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.module.rss.config;

import org.mule.config.spring.parsers.specific.RouterDefinitionParser;
import org.mule.config.spring.parsers.specific.endpoint.TransportEndpointDefinitionParser;
import org.mule.module.rss.endpoint.RssInboundEndpointFactoryBean;
import org.mule.module.rss.routing.FeedSplitter;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;


public class RssNamespaceHandler extends NamespaceHandlerSupport
{
    public void init()
    {
        registerBeanDefinitionParser("inbound-endpoint", new TransportEndpointDefinitionParser("rss", true, RssInboundEndpointFactoryBean.class, new String[]{"lastUpdate", "splitFeed", "acceptedMimeTypes", "pollingFrequency"}, new String[][]{}, new String[][]{}));
        registerBeanDefinitionParser("feed-splitter", new RouterDefinitionParser(FeedSplitter.class));
        
    }
}
