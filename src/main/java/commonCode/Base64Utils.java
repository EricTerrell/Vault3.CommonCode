/*
  Vault 3
  (C) Copyright 2025, Eric Bergman-Terrell

  This file is part of Vault 3.

  Vault 3 is free software: you can redistribute it and/or modify
  it under the terms of the GNU General Public License as published by
  the Free Software Foundation, either version 3 of the License, or
  (at your option) any later version.

  Vault 3 is distributed in the hope that it will be useful,
  but WITHOUT ANY WARRANTY; without even the implied warranty of
  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  GNU General Public License for more details.

  You should have received a copy of the GNU General Public License
  along with Vault 3.  If not, see <http://www.gnu.org/licenses/>.
*/

package commonCode;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Utils {
    /***
     * Base64 encodes a byte array to a String using UTF-8 encoding
     * @param src byte array
     * @return Base 64-encoded string
     */
    public static String encodeToString(byte[] src) {
        return new String(Base64.getEncoder().encode(src), StandardCharsets.UTF_8);
    }

    /***
     * Base64 decodes a String, using UTF-8 encoding, to a byte array
     * @param src String
     * @return byte array
     */
    public static byte[] decode(String src) {
        return Base64.getDecoder().decode(src.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Base64 encodes a string (safe for foreign language text).
     * @param text original text
     * @return encoded text
     */
    public static String i18nEncode(String text) {
        String result = null;

        if (text != null) {
            byte[] buffer = text.getBytes(StandardCharsets.UTF_8);

            result = encodeToString(buffer);
        }

        return result;
    }

    /**
     * Base64 decodes a string (safe for foreign language text).
     * @param text	encoded text
     * @return	original text
     */
    public static String i18nDecode(String text) {
        String result = null;

        if (text != null) {
            byte[] decodedBuffer = decode(text);
            result = new String(decodedBuffer, StandardCharsets.UTF_8);
        }

        return result;
    }
}