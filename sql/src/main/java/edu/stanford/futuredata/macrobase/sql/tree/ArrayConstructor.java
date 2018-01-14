/*
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
package edu.stanford.futuredata.macrobase.sql.tree;

import static java.util.Objects.requireNonNull;

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ArrayConstructor
    extends Expression {

    public static final String ARRAY_CONSTRUCTOR = "ARRAY_CONSTRUCTOR";
    private final List<Expression> values;

    public ArrayConstructor(List<Expression> values) {
        this(Optional.empty(), values);
    }

    public ArrayConstructor(NodeLocation location, List<Expression> values) {
        this(Optional.of(location), values);
    }

    private ArrayConstructor(Optional<NodeLocation> location, List<Expression> values) {
        super(location);
        requireNonNull(values, "values is null");
        this.values = ImmutableList.copyOf(values);
    }

    public List<Expression> getValues() {
        return values;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitArrayConstructor(this, context);
    }

    @Override
    public List<? extends Node> getChildren() {
        return values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ArrayConstructor that = (ArrayConstructor) o;
        return Objects.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        return values.hashCode();
    }
}
