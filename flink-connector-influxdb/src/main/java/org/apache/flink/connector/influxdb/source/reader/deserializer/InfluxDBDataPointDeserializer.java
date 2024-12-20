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
package org.apache.flink.connector.influxdb.source.reader.deserializer;

import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.java.typeutils.ResultTypeQueryable;
import org.apache.flink.api.java.typeutils.TypeExtractor;
import org.apache.flink.connector.influxdb.common.DataPoint;

import java.io.IOException;
import java.io.Serializable;

/** An interface for the deserialization of InfluxDB data points. */
public interface InfluxDBDataPointDeserializer<OUT> extends Serializable, ResultTypeQueryable<OUT> {

    /**
     * Deserialize a data point into the given collector.
     *
     * @param dataPoint the {@code DataPoint} to deserialize.
     * @throws IOException if the deserialization failed.
     */
    OUT deserialize(DataPoint dataPoint) throws IOException;

    // static function for single data point

    @Override
    default TypeInformation<OUT> getProducedType() {
        return TypeExtractor.createTypeInfo(
                InfluxDBDataPointDeserializer.class, this.getClass(), 0, null, null);
    }
}
