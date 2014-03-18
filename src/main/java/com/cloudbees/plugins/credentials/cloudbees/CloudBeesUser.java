/*
 * The MIT License
 *
 * Copyright 2014 CloudBees.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.cloudbees.plugins.credentials.cloudbees;

import com.cloudbees.plugins.credentials.Credentials;
import hudson.util.Secret;

import java.util.List;

/**
 * Represents a CloudBees user's credentials
 */
public interface CloudBeesUser extends Credentials {
    /**
     * Returns the email address of the user (which is the name they login to CloudBees with).
     *
     * @return the email address of the user (which is the name they login to CloudBees with).
     */
    String getName();

    /**
     * Returns the full name of the user that the account belongs to (or {@link #getName()} if that is not available).
     *
     * @return the full name of the user that the account belongs to.
     */
    String getDisplayName();

    /**
     * Returns the API key for the user.
     *
     * @return the API key for the user.
     */
    String getAPIKey();

    /**
     * Returns the Secret key for the user.
     *
     * @return the Secret key for the user.
     */
    Secret getAPISecret();

    /**
     * Returns the UID of the user.
     *
     * @return the UID of the user.
     */
    String getUID();

    /**
     * Returns the CloudBees accounts that this user belongs to.
     *
     * @return the CloudBees accounts that this user belongs to.
     */
    List<CloudBeesAccount> getAccounts();

    /**
     * Returns the named CloudBees account or {@code null} if not found.
     *
     * @param name the {@link CloudBeesAccount#getName()} of the account to find.
     * @return the named CloudBees account or {@code null} if not found.
     */
    CloudBeesAccount getAccount(String name);

}
