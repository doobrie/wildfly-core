/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2014, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jboss.as.controller.capability.registry;

/**
 * Registration information for requirement for a {@link org.jboss.as.controller.capability.RuntimeCapability}. As a runtime
 * requirement is associated with an actual management model, the registration exposes the {@link #getRegistrationPoint() point in the model}
 * that triggered the requirement.
 *
 * @author Brian Stansberry (c) 2014 Red Hat Inc.
 */
public class RuntimeRequirementRegistration extends RequirementRegistration {

    private final RegistrationPoint registrationPoint;

    public RuntimeRequirementRegistration(String requiredName, String dependentName, CapabilityContext dependentContext,
                                          RegistrationPoint registrationPoint) {
        super(requiredName, dependentName, dependentContext);
        this.registrationPoint = registrationPoint;
    }

    public RuntimeRequirementRegistration(String requiredName, RuntimeCapabilityRegistration dependent) {
        super(requiredName, dependent.getCapabilityId());
        this.registrationPoint =  dependent.getRegistrationPoint();
    }

    public RegistrationPoint getRegistrationPoint() {
        return registrationPoint;
    }

}
