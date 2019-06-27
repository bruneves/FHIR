/**
 * (C) Copyright IBM Corp. 2019
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package com.ibm.watsonhealth.fhir.model.type;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Generated;

import com.ibm.watsonhealth.fhir.model.visitor.Visitor;

/**
 * <p>
 * The metadata about a resource. This is content in the resource that is maintained by the infrastructure. Changes to 
 * the content might not always be associated with version changes to the resource.
 * </p>
 */
@Generated("com.ibm.watsonhealth.fhir.tools.CodeGenerator")
public class Meta extends Element {
    private final Id versionId;
    private final Instant lastUpdated;
    private final Uri source;
    private final List<Canonical> profile;
    private final List<Coding> security;
    private final List<Coding> tag;

    private Meta(Builder builder) {
        super(builder);
        this.versionId = builder.versionId;
        this.lastUpdated = builder.lastUpdated;
        this.source = builder.source;
        this.profile = builder.profile;
        this.security = builder.security;
        this.tag = builder.tag;
    }

    /**
     * <p>
     * The version specific identifier, as it appears in the version portion of the URL. This value changes when the resource 
     * is created, updated, or deleted.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link Id}.
     */
    public Id getVersionId() {
        return versionId;
    }

    /**
     * <p>
     * When the resource last changed - e.g. when the version changed.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link Instant}.
     */
    public Instant getLastUpdated() {
        return lastUpdated;
    }

    /**
     * <p>
     * A uri that identifies the source system of the resource. This provides a minimal amount of [Provenance](provenance.
     * html#) information that can be used to track or differentiate the source of information in the resource. The source 
     * may identify another FHIR server, document, message, database, etc.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link Uri}.
     */
    public Uri getSource() {
        return source;
    }

    /**
     * <p>
     * A list of profiles (references to [StructureDefinition](structuredefinition.html#) resources) that this resource 
     * claims to conform to. The URL is a reference to [StructureDefinition.url](structuredefinition-definitions.
     * html#StructureDefinition.url).
     * </p>
     * 
     * @return
     *     A list containing immutable objects of type {@link Canonical}.
     */
    public List<Canonical> getProfile() {
        return profile;
    }

    /**
     * <p>
     * Security labels applied to this resource. These tags connect specific resources to the overall security policy and 
     * infrastructure.
     * </p>
     * 
     * @return
     *     A list containing immutable objects of type {@link Coding}.
     */
    public List<Coding> getSecurity() {
        return security;
    }

    /**
     * <p>
     * Tags applied to this resource. Tags are intended to be used to identify and relate resources to process and workflow, 
     * and applications are not required to consider the tags when interpreting the meaning of a resource.
     * </p>
     * 
     * @return
     *     A list containing immutable objects of type {@link Coding}.
     */
    public List<Coding> getTag() {
        return tag;
    }

    @Override
    public void accept(java.lang.String elementName, Visitor visitor) {
        if (visitor.preVisit(this)) {
            visitor.visitStart(elementName, this);
            if (visitor.visit(elementName, this)) {
                // visit children
                accept(id, "id", visitor);
                accept(extension, "extension", visitor, Extension.class);
                accept(versionId, "versionId", visitor);
                accept(lastUpdated, "lastUpdated", visitor);
                accept(source, "source", visitor);
                accept(profile, "profile", visitor, Canonical.class);
                accept(security, "security", visitor, Coding.class);
                accept(tag, "tag", visitor, Coding.class);
            }
            visitor.visitEnd(elementName, this);
            visitor.postVisit(this);
        }
    }

    @Override
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.id = id;
        builder.extension.addAll(extension);
        builder.versionId = versionId;
        builder.lastUpdated = lastUpdated;
        builder.source = source;
        builder.profile.addAll(profile);
        builder.security.addAll(security);
        builder.tag.addAll(tag);
        return builder;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends Element.Builder {
        // optional
        private Id versionId;
        private Instant lastUpdated;
        private Uri source;
        private List<Canonical> profile = new ArrayList<>();
        private List<Coding> security = new ArrayList<>();
        private List<Coding> tag = new ArrayList<>();

        private Builder() {
            super();
        }

        /**
         * <p>
         * Unique id for the element within a resource (for internal references). This may be any string value that does not 
         * contain spaces.
         * </p>
         * 
         * @param id
         *     Unique id for inter-element referencing
         * 
         * @return
         *     A reference to this Builder instance.
         */
        @Override
        public Builder id(java.lang.String id) {
            return (Builder) super.id(id);
        }

        /**
         * <p>
         * May be used to represent additional information that is not part of the basic definition of the element. To make the 
         * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
         * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
         * of the definition of the extension.
         * </p>
         * 
         * @param extension
         *     Additional content defined by implementations
         * 
         * @return
         *     A reference to this Builder instance.
         */
        @Override
        public Builder extension(Extension... extension) {
            return (Builder) super.extension(extension);
        }

        /**
         * <p>
         * May be used to represent additional information that is not part of the basic definition of the element. To make the 
         * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
         * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
         * of the definition of the extension.
         * </p>
         * 
         * @param extension
         *     Additional content defined by implementations
         * 
         * @return
         *     A reference to this Builder instance.
         */
        @Override
        public Builder extension(Collection<Extension> extension) {
            return (Builder) super.extension(extension);
        }

        /**
         * <p>
         * The version specific identifier, as it appears in the version portion of the URL. This value changes when the resource 
         * is created, updated, or deleted.
         * </p>
         * 
         * @param versionId
         *     Version specific identifier
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder versionId(Id versionId) {
            this.versionId = versionId;
            return this;
        }

        /**
         * <p>
         * When the resource last changed - e.g. when the version changed.
         * </p>
         * 
         * @param lastUpdated
         *     When the resource version last changed
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder lastUpdated(Instant lastUpdated) {
            this.lastUpdated = lastUpdated;
            return this;
        }

        /**
         * <p>
         * A uri that identifies the source system of the resource. This provides a minimal amount of [Provenance](provenance.
         * html#) information that can be used to track or differentiate the source of information in the resource. The source 
         * may identify another FHIR server, document, message, database, etc.
         * </p>
         * 
         * @param source
         *     Identifies where the resource comes from
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder source(Uri source) {
            this.source = source;
            return this;
        }

        /**
         * <p>
         * A list of profiles (references to [StructureDefinition](structuredefinition.html#) resources) that this resource 
         * claims to conform to. The URL is a reference to [StructureDefinition.url](structuredefinition-definitions.
         * html#StructureDefinition.url).
         * </p>
         * 
         * @param profile
         *     Profiles this resource claims to conform to
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder profile(Canonical... profile) {
            for (Canonical value : profile) {
                this.profile.add(value);
            }
            return this;
        }

        /**
         * <p>
         * A list of profiles (references to [StructureDefinition](structuredefinition.html#) resources) that this resource 
         * claims to conform to. The URL is a reference to [StructureDefinition.url](structuredefinition-definitions.
         * html#StructureDefinition.url).
         * </p>
         * 
         * @param profile
         *     Profiles this resource claims to conform to
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder profile(Collection<Canonical> profile) {
            this.profile.addAll(profile);
            return this;
        }

        /**
         * <p>
         * Security labels applied to this resource. These tags connect specific resources to the overall security policy and 
         * infrastructure.
         * </p>
         * 
         * @param security
         *     Security Labels applied to this resource
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder security(Coding... security) {
            for (Coding value : security) {
                this.security.add(value);
            }
            return this;
        }

        /**
         * <p>
         * Security labels applied to this resource. These tags connect specific resources to the overall security policy and 
         * infrastructure.
         * </p>
         * 
         * @param security
         *     Security Labels applied to this resource
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder security(Collection<Coding> security) {
            this.security.addAll(security);
            return this;
        }

        /**
         * <p>
         * Tags applied to this resource. Tags are intended to be used to identify and relate resources to process and workflow, 
         * and applications are not required to consider the tags when interpreting the meaning of a resource.
         * </p>
         * 
         * @param tag
         *     Tags applied to this resource
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder tag(Coding... tag) {
            for (Coding value : tag) {
                this.tag.add(value);
            }
            return this;
        }

        /**
         * <p>
         * Tags applied to this resource. Tags are intended to be used to identify and relate resources to process and workflow, 
         * and applications are not required to consider the tags when interpreting the meaning of a resource.
         * </p>
         * 
         * @param tag
         *     Tags applied to this resource
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder tag(Collection<Coding> tag) {
            this.tag.addAll(tag);
            return this;
        }

        @Override
        public Meta build() {
            return new Meta(this);
        }
    }
}