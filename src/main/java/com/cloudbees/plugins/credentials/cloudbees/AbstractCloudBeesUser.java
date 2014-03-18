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

import com.cloudbees.plugins.credentials.BaseCredentials;
import com.cloudbees.plugins.credentials.CredentialsScope;

import java.util.List;

/**
 * Useful base class for implementations of {@link CloudBeesUser}.
 */
public abstract class AbstractCloudBeesUser extends BaseCredentials implements CloudBeesUser {

    protected AbstractCloudBeesUser() {
        super();
    }

    protected AbstractCloudBeesUser(CredentialsScope scope) {
        super(scope);
    }

    /**
     * Returns the named CloudBees account or {@code null} if not found.
     *
     * @param name the {@link CloudBeesAccount#getName()} of the account to find.
     * @return the named CloudBees account or {@code null} if not found.
     */
    public CloudBeesAccount getAccount(String name) {
        List<CloudBeesAccount> accounts = getAccounts();
        if (accounts != null) {
            for (CloudBeesAccount account : accounts) {
                if (account.getName().equals(name)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CloudBeesUser)) {
            return false;
        }

        CloudBeesUser that = (CloudBeesUser) o;

        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) {
            return false;
        }

        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final int hashCode() {
        return getName() != null ? getName().hashCode() : 0;
    }

}
