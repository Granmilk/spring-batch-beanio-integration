/*
 *
 *  *
 *  *      * Copyright (c) 2019, Cabal Brasil and/or its affiliates. All rights reserved.
 *  *      * CABAL BRASIL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *  *
 *
 */

package com.demo.project.core.service;

public interface ServiceFactory {

	MerchantService getService(String registerId);
}
