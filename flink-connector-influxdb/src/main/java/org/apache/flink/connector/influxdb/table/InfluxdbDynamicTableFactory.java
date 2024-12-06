/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.flink.connector.influxdb.table;

import org.apache.flink.annotation.Internal;
import org.apache.flink.configuration.ConfigOption;
import org.apache.flink.configuration.ConfigOptions;
import org.apache.flink.table.connector.sink.DynamicTableSink;
import org.apache.flink.table.connector.source.DynamicTableSource;
import org.apache.flink.table.factories.DynamicTableSinkFactory;
import org.apache.flink.table.factories.DynamicTableSourceFactory;
import org.apache.flink.table.factories.FactoryUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

@Internal
public class InfluxdbDynamicTableFactory
        implements DynamicTableSourceFactory, DynamicTableSinkFactory {

    private static final Logger LOG = LoggerFactory.getLogger(InfluxdbDynamicTableFactory.class);
    private static final ConfigOption<String> SINK_SEMANTIC =
            ConfigOptions.key("sink.semantic")
                         .stringType()
                         .noDefaultValue()
                         .withDescription("Optional semantic when committing.");

    public static final String IDENTIFIER = "influxdb";

    @Override
    public String factoryIdentifier() {
        return IDENTIFIER;
    }

    @Override
    public Set<ConfigOption<?>> requiredOptions() {
        final Set<ConfigOption<?>> options = new HashSet<>();
        //options.add(PROPS_BOOTSTRAP_SERVERS);
        return options;
    }

    @Override
    public Set<ConfigOption<?>> optionalOptions() {
        final Set<ConfigOption<?>> options = new HashSet<>();
        options.add(FactoryUtil.FORMAT);
        options.add(SINK_SEMANTIC);
        return options;
    }

    @Override
    public Set<ConfigOption<?>> forwardOptions() {
        return null;
    }

    @Override
    public DynamicTableSource createDynamicTableSource(Context context) {

        return null;
    }

    @Override
    public DynamicTableSink createDynamicTableSink(Context context) {
        return null;
    }
}
