/*
 * Copyright (C) 2017 Uele, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.uele.reidx.android.utils;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

public class Utils {

    private Utils() {
        // Empty private constructor
    }

    public static String loadJSONFromAsset(final Context context, final String fileName)
            throws IOException {
        String json;

        InputStream is = context.getAssets().open(fileName);
        int size = is.available();
        byte[] buffer = new byte[size];

        is.read(buffer);
        is.close();

        json = new String(buffer, "UTF-8");

        return json;
    }
}