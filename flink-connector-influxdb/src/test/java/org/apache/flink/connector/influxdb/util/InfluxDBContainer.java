/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.flink.connector.influxdb.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testcontainers.utility.DockerImageName;

public final class InfluxDBContainer extends InfluxDBContainerCustom {

    private static final Logger LOG = LoggerFactory.getLogger(InfluxDBContainer.class);

    private static final DockerImageName DEFAULT_IMAGE_NAME =
            DockerImageName.parse("quay.io/influxdb/influxdb:v2.0.2");

    private InfluxDBContainer(final DockerImageName imageName) {
        super(imageName);

    }

    public static InfluxDBContainer createWithDefaultTag() {
        LOG.info("Starting influxDB test container with default tag {}", DEFAULT_IMAGE_NAME);
        return new InfluxDBContainer(DEFAULT_IMAGE_NAME);
    }

}
