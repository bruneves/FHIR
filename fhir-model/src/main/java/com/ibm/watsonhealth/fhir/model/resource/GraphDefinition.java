/**
 * (C) Copyright IBM Corp. 2019
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package com.ibm.watsonhealth.fhir.model.resource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Generated;

import com.ibm.watsonhealth.fhir.model.annotation.Constraint;
import com.ibm.watsonhealth.fhir.model.type.BackboneElement;
import com.ibm.watsonhealth.fhir.model.type.Boolean;
import com.ibm.watsonhealth.fhir.model.type.Canonical;
import com.ibm.watsonhealth.fhir.model.type.Code;
import com.ibm.watsonhealth.fhir.model.type.CodeableConcept;
import com.ibm.watsonhealth.fhir.model.type.CompartmentCode;
import com.ibm.watsonhealth.fhir.model.type.ContactDetail;
import com.ibm.watsonhealth.fhir.model.type.DateTime;
import com.ibm.watsonhealth.fhir.model.type.Extension;
import com.ibm.watsonhealth.fhir.model.type.GraphCompartmentRule;
import com.ibm.watsonhealth.fhir.model.type.GraphCompartmentUse;
import com.ibm.watsonhealth.fhir.model.type.Id;
import com.ibm.watsonhealth.fhir.model.type.Integer;
import com.ibm.watsonhealth.fhir.model.type.Markdown;
import com.ibm.watsonhealth.fhir.model.type.Meta;
import com.ibm.watsonhealth.fhir.model.type.Narrative;
import com.ibm.watsonhealth.fhir.model.type.PublicationStatus;
import com.ibm.watsonhealth.fhir.model.type.ResourceType;
import com.ibm.watsonhealth.fhir.model.type.String;
import com.ibm.watsonhealth.fhir.model.type.Uri;
import com.ibm.watsonhealth.fhir.model.type.UsageContext;
import com.ibm.watsonhealth.fhir.model.util.ValidationSupport;
import com.ibm.watsonhealth.fhir.model.visitor.Visitor;

/**
 * <p>
 * A formal computable definition of a graph of resources - that is, a coherent set of resources that form a graph by 
 * following references. The Graph Definition resource defines a set and makes rules about the set.
 * </p>
 */
@Constraint(
    key = "gdf-0",
    severity = "warning",
    human = "Name should be usable as an identifier for the module by machine processing applications such as code generation",
    expression = "name.matches('[A-Z]([A-Za-z0-9_]){0,254}')"
)
@Generated("com.ibm.watsonhealth.fhir.tools.CodeGenerator")
public class GraphDefinition extends DomainResource {
    private final Uri url;
    private final String version;
    private final String name;
    private final PublicationStatus status;
    private final Boolean experimental;
    private final DateTime date;
    private final String publisher;
    private final List<ContactDetail> contact;
    private final Markdown description;
    private final List<UsageContext> useContext;
    private final List<CodeableConcept> jurisdiction;
    private final Markdown purpose;
    private final ResourceType start;
    private final Canonical profile;
    private final List<Link> link;

    private GraphDefinition(Builder builder) {
        super(builder);
        this.url = builder.url;
        this.version = builder.version;
        this.name = ValidationSupport.requireNonNull(builder.name, "name");
        this.status = ValidationSupport.requireNonNull(builder.status, "status");
        this.experimental = builder.experimental;
        this.date = builder.date;
        this.publisher = builder.publisher;
        this.contact = builder.contact;
        this.description = builder.description;
        this.useContext = builder.useContext;
        this.jurisdiction = builder.jurisdiction;
        this.purpose = builder.purpose;
        this.start = ValidationSupport.requireNonNull(builder.start, "start");
        this.profile = builder.profile;
        this.link = builder.link;
    }

    /**
     * <p>
     * An absolute URI that is used to identify this graph definition when it is referenced in a specification, model, design 
     * or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address 
     * at which at which an authoritative instance of this graph definition is (or will be) published. This URL can be the 
     * target of a canonical reference. It SHALL remain the same when the graph definition is stored on different servers.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link Uri}.
     */
    public Uri getUrl() {
        return url;
    }

    /**
     * <p>
     * The identifier that is used to identify this version of the graph definition when it is referenced in a specification, 
     * model, design or instance. This is an arbitrary value managed by the graph definition author and is not expected to be 
     * globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is 
     * also no expectation that versions can be placed in a lexicographical sequence.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link String}.
     */
    public String getVersion() {
        return version;
    }

    /**
     * <p>
     * A natural language name identifying the graph definition. This name should be usable as an identifier for the module 
     * by machine processing applications such as code generation.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link String}.
     */
    public String getName() {
        return name;
    }

    /**
     * <p>
     * The status of this graph definition. Enables tracking the life-cycle of the content.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link PublicationStatus}.
     */
    public PublicationStatus getStatus() {
        return status;
    }

    /**
     * <p>
     * A Boolean value to indicate that this graph definition is authored for testing purposes (or 
     * education/evaluation/marketing) and is not intended to be used for genuine usage.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link Boolean}.
     */
    public Boolean getExperimental() {
        return experimental;
    }

    /**
     * <p>
     * The date (and optionally time) when the graph definition was published. The date must change when the business version 
     * changes and it must change if the status code changes. In addition, it should change when the substantive content of 
     * the graph definition changes.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link DateTime}.
     */
    public DateTime getDate() {
        return date;
    }

    /**
     * <p>
     * The name of the organization or individual that published the graph definition.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link String}.
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * <p>
     * Contact details to assist a user in finding and communicating with the publisher.
     * </p>
     * 
     * @return
     *     A list containing immutable objects of type {@link ContactDetail}.
     */
    public List<ContactDetail> getContact() {
        return contact;
    }

    /**
     * <p>
     * A free text natural language description of the graph definition from a consumer's perspective.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link Markdown}.
     */
    public Markdown getDescription() {
        return description;
    }

    /**
     * <p>
     * The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be 
     * general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and 
     * may be used to assist with indexing and searching for appropriate graph definition instances.
     * </p>
     * 
     * @return
     *     A list containing immutable objects of type {@link UsageContext}.
     */
    public List<UsageContext> getUseContext() {
        return useContext;
    }

    /**
     * <p>
     * A legal or geographic region in which the graph definition is intended to be used.
     * </p>
     * 
     * @return
     *     A list containing immutable objects of type {@link CodeableConcept}.
     */
    public List<CodeableConcept> getJurisdiction() {
        return jurisdiction;
    }

    /**
     * <p>
     * Explanation of why this graph definition is needed and why it has been designed as it has.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link Markdown}.
     */
    public Markdown getPurpose() {
        return purpose;
    }

    /**
     * <p>
     * The type of FHIR resource at which instances of this graph start.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link ResourceType}.
     */
    public ResourceType getStart() {
        return start;
    }

    /**
     * <p>
     * The profile that describes the use of the base resource.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link Canonical}.
     */
    public Canonical getProfile() {
        return profile;
    }

    /**
     * <p>
     * Links this graph makes rules about.
     * </p>
     * 
     * @return
     *     A list containing immutable objects of type {@link Link}.
     */
    public List<Link> getLink() {
        return link;
    }

    @Override
    public void accept(java.lang.String elementName, Visitor visitor) {
        if (visitor.preVisit(this)) {
            visitor.visitStart(elementName, this);
            if (visitor.visit(elementName, this)) {
                // visit children
                accept(id, "id", visitor);
                accept(meta, "meta", visitor);
                accept(implicitRules, "implicitRules", visitor);
                accept(language, "language", visitor);
                accept(text, "text", visitor);
                accept(contained, "contained", visitor, Resource.class);
                accept(extension, "extension", visitor, Extension.class);
                accept(modifierExtension, "modifierExtension", visitor, Extension.class);
                accept(url, "url", visitor);
                accept(version, "version", visitor);
                accept(name, "name", visitor);
                accept(status, "status", visitor);
                accept(experimental, "experimental", visitor);
                accept(date, "date", visitor);
                accept(publisher, "publisher", visitor);
                accept(contact, "contact", visitor, ContactDetail.class);
                accept(description, "description", visitor);
                accept(useContext, "useContext", visitor, UsageContext.class);
                accept(jurisdiction, "jurisdiction", visitor, CodeableConcept.class);
                accept(purpose, "purpose", visitor);
                accept(start, "start", visitor);
                accept(profile, "profile", visitor);
                accept(link, "link", visitor, Link.class);
            }
            visitor.visitEnd(elementName, this);
            visitor.postVisit(this);
        }
    }

    @Override
    public Builder toBuilder() {
        Builder builder = new Builder(name, status, start);
        builder.id = id;
        builder.meta = meta;
        builder.implicitRules = implicitRules;
        builder.language = language;
        builder.text = text;
        builder.contained.addAll(contained);
        builder.extension.addAll(extension);
        builder.modifierExtension.addAll(modifierExtension);
        builder.url = url;
        builder.version = version;
        builder.experimental = experimental;
        builder.date = date;
        builder.publisher = publisher;
        builder.contact.addAll(contact);
        builder.description = description;
        builder.useContext.addAll(useContext);
        builder.jurisdiction.addAll(jurisdiction);
        builder.purpose = purpose;
        builder.profile = profile;
        builder.link.addAll(link);
        return builder;
    }

    public static Builder builder(String name, PublicationStatus status, ResourceType start) {
        return new Builder(name, status, start);
    }

    public static class Builder extends DomainResource.Builder {
        // required
        private final String name;
        private final PublicationStatus status;
        private final ResourceType start;

        // optional
        private Uri url;
        private String version;
        private Boolean experimental;
        private DateTime date;
        private String publisher;
        private List<ContactDetail> contact = new ArrayList<>();
        private Markdown description;
        private List<UsageContext> useContext = new ArrayList<>();
        private List<CodeableConcept> jurisdiction = new ArrayList<>();
        private Markdown purpose;
        private Canonical profile;
        private List<Link> link = new ArrayList<>();

        private Builder(String name, PublicationStatus status, ResourceType start) {
            super();
            this.name = name;
            this.status = status;
            this.start = start;
        }

        /**
         * <p>
         * The logical id of the resource, as used in the URL for the resource. Once assigned, this value never changes.
         * </p>
         * 
         * @param id
         *     Logical id of this artifact
         * 
         * @return
         *     A reference to this Builder instance.
         */
        @Override
        public Builder id(Id id) {
            return (Builder) super.id(id);
        }

        /**
         * <p>
         * The metadata about the resource. This is content that is maintained by the infrastructure. Changes to the content 
         * might not always be associated with version changes to the resource.
         * </p>
         * 
         * @param meta
         *     Metadata about the resource
         * 
         * @return
         *     A reference to this Builder instance.
         */
        @Override
        public Builder meta(Meta meta) {
            return (Builder) super.meta(meta);
        }

        /**
         * <p>
         * A reference to a set of rules that were followed when the resource was constructed, and which must be understood when 
         * processing the content. Often, this is a reference to an implementation guide that defines the special rules along 
         * with other profiles etc.
         * </p>
         * 
         * @param implicitRules
         *     A set of rules under which this content was created
         * 
         * @return
         *     A reference to this Builder instance.
         */
        @Override
        public Builder implicitRules(Uri implicitRules) {
            return (Builder) super.implicitRules(implicitRules);
        }

        /**
         * <p>
         * The base language in which the resource is written.
         * </p>
         * 
         * @param language
         *     Language of the resource content
         * 
         * @return
         *     A reference to this Builder instance.
         */
        @Override
        public Builder language(Code language) {
            return (Builder) super.language(language);
        }

        /**
         * <p>
         * A human-readable narrative that contains a summary of the resource and can be used to represent the content of the 
         * resource to a human. The narrative need not encode all the structured data, but is required to contain sufficient 
         * detail to make it "clinically safe" for a human to just read the narrative. Resource definitions may define what 
         * content should be represented in the narrative to ensure clinical safety.
         * </p>
         * 
         * @param text
         *     Text summary of the resource, for human interpretation
         * 
         * @return
         *     A reference to this Builder instance.
         */
        @Override
        public Builder text(Narrative text) {
            return (Builder) super.text(text);
        }

        /**
         * <p>
         * These resources do not have an independent existence apart from the resource that contains them - they cannot be 
         * identified independently, and nor can they have their own independent transaction scope.
         * </p>
         * 
         * @param contained
         *     Contained, inline Resources
         * 
         * @return
         *     A reference to this Builder instance.
         */
        @Override
        public Builder contained(Resource... contained) {
            return (Builder) super.contained(contained);
        }

        /**
         * <p>
         * These resources do not have an independent existence apart from the resource that contains them - they cannot be 
         * identified independently, and nor can they have their own independent transaction scope.
         * </p>
         * 
         * @param contained
         *     Contained, inline Resources
         * 
         * @return
         *     A reference to this Builder instance.
         */
        @Override
        public Builder contained(Collection<Resource> contained) {
            return (Builder) super.contained(contained);
        }

        /**
         * <p>
         * May be used to represent additional information that is not part of the basic definition of the resource. To make the 
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
         * May be used to represent additional information that is not part of the basic definition of the resource. To make the 
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
         * May be used to represent additional information that is not part of the basic definition of the resource and that 
         * modifies the understanding of the element that contains it and/or the understanding of the containing element's 
         * descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe and 
         * manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
         * implementer is allowed to define an extension, there is a set of requirements that SHALL be met as part of the 
         * definition of the extension. Applications processing a resource are required to check for modifier extensions.
         * </p>
         * <p>
         * Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
         * change the meaning of modifierExtension itself).
         * </p>
         * 
         * @param modifierExtension
         *     Extensions that cannot be ignored
         * 
         * @return
         *     A reference to this Builder instance.
         */
        @Override
        public Builder modifierExtension(Extension... modifierExtension) {
            return (Builder) super.modifierExtension(modifierExtension);
        }

        /**
         * <p>
         * May be used to represent additional information that is not part of the basic definition of the resource and that 
         * modifies the understanding of the element that contains it and/or the understanding of the containing element's 
         * descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe and 
         * manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
         * implementer is allowed to define an extension, there is a set of requirements that SHALL be met as part of the 
         * definition of the extension. Applications processing a resource are required to check for modifier extensions.
         * </p>
         * <p>
         * Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
         * change the meaning of modifierExtension itself).
         * </p>
         * 
         * @param modifierExtension
         *     Extensions that cannot be ignored
         * 
         * @return
         *     A reference to this Builder instance.
         */
        @Override
        public Builder modifierExtension(Collection<Extension> modifierExtension) {
            return (Builder) super.modifierExtension(modifierExtension);
        }

        /**
         * <p>
         * An absolute URI that is used to identify this graph definition when it is referenced in a specification, model, design 
         * or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address 
         * at which at which an authoritative instance of this graph definition is (or will be) published. This URL can be the 
         * target of a canonical reference. It SHALL remain the same when the graph definition is stored on different servers.
         * </p>
         * 
         * @param url
         *     Canonical identifier for this graph definition, represented as a URI (globally unique)
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder url(Uri url) {
            this.url = url;
            return this;
        }

        /**
         * <p>
         * The identifier that is used to identify this version of the graph definition when it is referenced in a specification, 
         * model, design or instance. This is an arbitrary value managed by the graph definition author and is not expected to be 
         * globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is 
         * also no expectation that versions can be placed in a lexicographical sequence.
         * </p>
         * 
         * @param version
         *     Business version of the graph definition
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder version(String version) {
            this.version = version;
            return this;
        }

        /**
         * <p>
         * A Boolean value to indicate that this graph definition is authored for testing purposes (or 
         * education/evaluation/marketing) and is not intended to be used for genuine usage.
         * </p>
         * 
         * @param experimental
         *     For testing purposes, not real usage
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder experimental(Boolean experimental) {
            this.experimental = experimental;
            return this;
        }

        /**
         * <p>
         * The date (and optionally time) when the graph definition was published. The date must change when the business version 
         * changes and it must change if the status code changes. In addition, it should change when the substantive content of 
         * the graph definition changes.
         * </p>
         * 
         * @param date
         *     Date last changed
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder date(DateTime date) {
            this.date = date;
            return this;
        }

        /**
         * <p>
         * The name of the organization or individual that published the graph definition.
         * </p>
         * 
         * @param publisher
         *     Name of the publisher (organization or individual)
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder publisher(String publisher) {
            this.publisher = publisher;
            return this;
        }

        /**
         * <p>
         * Contact details to assist a user in finding and communicating with the publisher.
         * </p>
         * 
         * @param contact
         *     Contact details for the publisher
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder contact(ContactDetail... contact) {
            for (ContactDetail value : contact) {
                this.contact.add(value);
            }
            return this;
        }

        /**
         * <p>
         * Contact details to assist a user in finding and communicating with the publisher.
         * </p>
         * 
         * @param contact
         *     Contact details for the publisher
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder contact(Collection<ContactDetail> contact) {
            this.contact.addAll(contact);
            return this;
        }

        /**
         * <p>
         * A free text natural language description of the graph definition from a consumer's perspective.
         * </p>
         * 
         * @param description
         *     Natural language description of the graph definition
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder description(Markdown description) {
            this.description = description;
            return this;
        }

        /**
         * <p>
         * The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be 
         * general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and 
         * may be used to assist with indexing and searching for appropriate graph definition instances.
         * </p>
         * 
         * @param useContext
         *     The context that the content is intended to support
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder useContext(UsageContext... useContext) {
            for (UsageContext value : useContext) {
                this.useContext.add(value);
            }
            return this;
        }

        /**
         * <p>
         * The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be 
         * general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and 
         * may be used to assist with indexing and searching for appropriate graph definition instances.
         * </p>
         * 
         * @param useContext
         *     The context that the content is intended to support
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder useContext(Collection<UsageContext> useContext) {
            this.useContext.addAll(useContext);
            return this;
        }

        /**
         * <p>
         * A legal or geographic region in which the graph definition is intended to be used.
         * </p>
         * 
         * @param jurisdiction
         *     Intended jurisdiction for graph definition (if applicable)
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder jurisdiction(CodeableConcept... jurisdiction) {
            for (CodeableConcept value : jurisdiction) {
                this.jurisdiction.add(value);
            }
            return this;
        }

        /**
         * <p>
         * A legal or geographic region in which the graph definition is intended to be used.
         * </p>
         * 
         * @param jurisdiction
         *     Intended jurisdiction for graph definition (if applicable)
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder jurisdiction(Collection<CodeableConcept> jurisdiction) {
            this.jurisdiction.addAll(jurisdiction);
            return this;
        }

        /**
         * <p>
         * Explanation of why this graph definition is needed and why it has been designed as it has.
         * </p>
         * 
         * @param purpose
         *     Why this graph definition is defined
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder purpose(Markdown purpose) {
            this.purpose = purpose;
            return this;
        }

        /**
         * <p>
         * The profile that describes the use of the base resource.
         * </p>
         * 
         * @param profile
         *     Profile on base resource
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder profile(Canonical profile) {
            this.profile = profile;
            return this;
        }

        /**
         * <p>
         * Links this graph makes rules about.
         * </p>
         * 
         * @param link
         *     Links this graph makes rules about
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder link(Link... link) {
            for (Link value : link) {
                this.link.add(value);
            }
            return this;
        }

        /**
         * <p>
         * Links this graph makes rules about.
         * </p>
         * 
         * @param link
         *     Links this graph makes rules about
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder link(Collection<Link> link) {
            this.link.addAll(link);
            return this;
        }

        @Override
        public GraphDefinition build() {
            return new GraphDefinition(this);
        }
    }

    /**
     * <p>
     * Links this graph makes rules about.
     * </p>
     */
    public static class Link extends BackboneElement {
        private final String path;
        private final String sliceName;
        private final Integer min;
        private final String max;
        private final String description;
        private final List<Target> target;

        private Link(Builder builder) {
            super(builder);
            this.path = builder.path;
            this.sliceName = builder.sliceName;
            this.min = builder.min;
            this.max = builder.max;
            this.description = builder.description;
            this.target = builder.target;
        }

        /**
         * <p>
         * A FHIR expression that identifies one of FHIR References to other resources.
         * </p>
         * 
         * @return
         *     An immutable object of type {@link String}.
         */
        public String getPath() {
            return path;
        }

        /**
         * <p>
         * Which slice (if profiled).
         * </p>
         * 
         * @return
         *     An immutable object of type {@link String}.
         */
        public String getSliceName() {
            return sliceName;
        }

        /**
         * <p>
         * Minimum occurrences for this link.
         * </p>
         * 
         * @return
         *     An immutable object of type {@link Integer}.
         */
        public Integer getMin() {
            return min;
        }

        /**
         * <p>
         * Maximum occurrences for this link.
         * </p>
         * 
         * @return
         *     An immutable object of type {@link String}.
         */
        public String getMax() {
            return max;
        }

        /**
         * <p>
         * Information about why this link is of interest in this graph definition.
         * </p>
         * 
         * @return
         *     An immutable object of type {@link String}.
         */
        public String getDescription() {
            return description;
        }

        /**
         * <p>
         * Potential target for the link.
         * </p>
         * 
         * @return
         *     A list containing immutable objects of type {@link Target}.
         */
        public List<Target> getTarget() {
            return target;
        }

        @Override
        public void accept(java.lang.String elementName, Visitor visitor) {
            if (visitor.preVisit(this)) {
                visitor.visitStart(elementName, this);
                if (visitor.visit(elementName, this)) {
                    // visit children
                    accept(id, "id", visitor);
                    accept(extension, "extension", visitor, Extension.class);
                    accept(modifierExtension, "modifierExtension", visitor, Extension.class);
                    accept(path, "path", visitor);
                    accept(sliceName, "sliceName", visitor);
                    accept(min, "min", visitor);
                    accept(max, "max", visitor);
                    accept(description, "description", visitor);
                    accept(target, "target", visitor, Target.class);
                }
                visitor.visitEnd(elementName, this);
                visitor.postVisit(this);
            }
        }

        @Override
        public Builder toBuilder() {
            return Builder.from(this);
        }

        public static Builder builder() {
            return new Builder();
        }

        public static class Builder extends BackboneElement.Builder {
            // optional
            private String path;
            private String sliceName;
            private Integer min;
            private String max;
            private String description;
            private List<Target> target = new ArrayList<>();

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
             * May be used to represent additional information that is not part of the basic definition of the element and that 
             * modifies the understanding of the element in which it is contained and/or the understanding of the containing 
             * element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe 
             * and manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
             * implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the 
             * extension. Applications processing a resource are required to check for modifier extensions.
             * </p>
             * <p>
             * Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
             * change the meaning of modifierExtension itself).
             * </p>
             * 
             * @param modifierExtension
             *     Extensions that cannot be ignored even if unrecognized
             * 
             * @return
             *     A reference to this Builder instance.
             */
            @Override
            public Builder modifierExtension(Extension... modifierExtension) {
                return (Builder) super.modifierExtension(modifierExtension);
            }

            /**
             * <p>
             * May be used to represent additional information that is not part of the basic definition of the element and that 
             * modifies the understanding of the element in which it is contained and/or the understanding of the containing 
             * element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe 
             * and manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
             * implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the 
             * extension. Applications processing a resource are required to check for modifier extensions.
             * </p>
             * <p>
             * Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
             * change the meaning of modifierExtension itself).
             * </p>
             * 
             * @param modifierExtension
             *     Extensions that cannot be ignored even if unrecognized
             * 
             * @return
             *     A reference to this Builder instance.
             */
            @Override
            public Builder modifierExtension(Collection<Extension> modifierExtension) {
                return (Builder) super.modifierExtension(modifierExtension);
            }

            /**
             * <p>
             * A FHIR expression that identifies one of FHIR References to other resources.
             * </p>
             * 
             * @param path
             *     Path in the resource that contains the link
             * 
             * @return
             *     A reference to this Builder instance.
             */
            public Builder path(String path) {
                this.path = path;
                return this;
            }

            /**
             * <p>
             * Which slice (if profiled).
             * </p>
             * 
             * @param sliceName
             *     Which slice (if profiled)
             * 
             * @return
             *     A reference to this Builder instance.
             */
            public Builder sliceName(String sliceName) {
                this.sliceName = sliceName;
                return this;
            }

            /**
             * <p>
             * Minimum occurrences for this link.
             * </p>
             * 
             * @param min
             *     Minimum occurrences for this link
             * 
             * @return
             *     A reference to this Builder instance.
             */
            public Builder min(Integer min) {
                this.min = min;
                return this;
            }

            /**
             * <p>
             * Maximum occurrences for this link.
             * </p>
             * 
             * @param max
             *     Maximum occurrences for this link
             * 
             * @return
             *     A reference to this Builder instance.
             */
            public Builder max(String max) {
                this.max = max;
                return this;
            }

            /**
             * <p>
             * Information about why this link is of interest in this graph definition.
             * </p>
             * 
             * @param description
             *     Why this link is specified
             * 
             * @return
             *     A reference to this Builder instance.
             */
            public Builder description(String description) {
                this.description = description;
                return this;
            }

            /**
             * <p>
             * Potential target for the link.
             * </p>
             * 
             * @param target
             *     Potential target for the link
             * 
             * @return
             *     A reference to this Builder instance.
             */
            public Builder target(Target... target) {
                for (Target value : target) {
                    this.target.add(value);
                }
                return this;
            }

            /**
             * <p>
             * Potential target for the link.
             * </p>
             * 
             * @param target
             *     Potential target for the link
             * 
             * @return
             *     A reference to this Builder instance.
             */
            public Builder target(Collection<Target> target) {
                this.target.addAll(target);
                return this;
            }

            @Override
            public Link build() {
                return new Link(this);
            }

            private static Builder from(Link link) {
                Builder builder = new Builder();
                builder.id = link.id;
                builder.extension.addAll(link.extension);
                builder.modifierExtension.addAll(link.modifierExtension);
                builder.path = link.path;
                builder.sliceName = link.sliceName;
                builder.min = link.min;
                builder.max = link.max;
                builder.description = link.description;
                builder.target.addAll(link.target);
                return builder;
            }
        }

        /**
         * <p>
         * Potential target for the link.
         * </p>
         */
        public static class Target extends BackboneElement {
            private final ResourceType type;
            private final String params;
            private final Canonical profile;
            private final List<Compartment> compartment;
            private final List<GraphDefinition.Link> link;

            private Target(Builder builder) {
                super(builder);
                this.type = ValidationSupport.requireNonNull(builder.type, "type");
                this.params = builder.params;
                this.profile = builder.profile;
                this.compartment = builder.compartment;
                this.link = builder.link;
            }

            /**
             * <p>
             * Type of resource this link refers to.
             * </p>
             * 
             * @return
             *     An immutable object of type {@link ResourceType}.
             */
            public ResourceType getType() {
                return type;
            }

            /**
             * <p>
             * A set of parameters to look up.
             * </p>
             * 
             * @return
             *     An immutable object of type {@link String}.
             */
            public String getParams() {
                return params;
            }

            /**
             * <p>
             * Profile for the target resource.
             * </p>
             * 
             * @return
             *     An immutable object of type {@link Canonical}.
             */
            public Canonical getProfile() {
                return profile;
            }

            /**
             * <p>
             * Compartment Consistency Rules.
             * </p>
             * 
             * @return
             *     A list containing immutable objects of type {@link Compartment}.
             */
            public List<Compartment> getCompartment() {
                return compartment;
            }

            /**
             * <p>
             * Additional links from target resource.
             * </p>
             * 
             * @return
             *     A list containing immutable objects of type {@link Link}.
             */
            public List<GraphDefinition.Link> getLink() {
                return link;
            }

            @Override
            public void accept(java.lang.String elementName, Visitor visitor) {
                if (visitor.preVisit(this)) {
                    visitor.visitStart(elementName, this);
                    if (visitor.visit(elementName, this)) {
                        // visit children
                        accept(id, "id", visitor);
                        accept(extension, "extension", visitor, Extension.class);
                        accept(modifierExtension, "modifierExtension", visitor, Extension.class);
                        accept(type, "type", visitor);
                        accept(params, "params", visitor);
                        accept(profile, "profile", visitor);
                        accept(compartment, "compartment", visitor, Compartment.class);
                        accept(link, "link", visitor, GraphDefinition.Link.class);
                    }
                    visitor.visitEnd(elementName, this);
                    visitor.postVisit(this);
                }
            }

            @Override
            public Builder toBuilder() {
                return Builder.from(this);
            }

            public static Builder builder(ResourceType type) {
                return new Builder(type);
            }

            public static class Builder extends BackboneElement.Builder {
                // required
                private final ResourceType type;

                // optional
                private String params;
                private Canonical profile;
                private List<Compartment> compartment = new ArrayList<>();
                private List<GraphDefinition.Link> link = new ArrayList<>();

                private Builder(ResourceType type) {
                    super();
                    this.type = type;
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
                 * May be used to represent additional information that is not part of the basic definition of the element and that 
                 * modifies the understanding of the element in which it is contained and/or the understanding of the containing 
                 * element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe 
                 * and manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
                 * implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the 
                 * extension. Applications processing a resource are required to check for modifier extensions.
                 * </p>
                 * <p>
                 * Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
                 * change the meaning of modifierExtension itself).
                 * </p>
                 * 
                 * @param modifierExtension
                 *     Extensions that cannot be ignored even if unrecognized
                 * 
                 * @return
                 *     A reference to this Builder instance.
                 */
                @Override
                public Builder modifierExtension(Extension... modifierExtension) {
                    return (Builder) super.modifierExtension(modifierExtension);
                }

                /**
                 * <p>
                 * May be used to represent additional information that is not part of the basic definition of the element and that 
                 * modifies the understanding of the element in which it is contained and/or the understanding of the containing 
                 * element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe 
                 * and manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
                 * implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the 
                 * extension. Applications processing a resource are required to check for modifier extensions.
                 * </p>
                 * <p>
                 * Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
                 * change the meaning of modifierExtension itself).
                 * </p>
                 * 
                 * @param modifierExtension
                 *     Extensions that cannot be ignored even if unrecognized
                 * 
                 * @return
                 *     A reference to this Builder instance.
                 */
                @Override
                public Builder modifierExtension(Collection<Extension> modifierExtension) {
                    return (Builder) super.modifierExtension(modifierExtension);
                }

                /**
                 * <p>
                 * A set of parameters to look up.
                 * </p>
                 * 
                 * @param params
                 *     Criteria for reverse lookup
                 * 
                 * @return
                 *     A reference to this Builder instance.
                 */
                public Builder params(String params) {
                    this.params = params;
                    return this;
                }

                /**
                 * <p>
                 * Profile for the target resource.
                 * </p>
                 * 
                 * @param profile
                 *     Profile for the target resource
                 * 
                 * @return
                 *     A reference to this Builder instance.
                 */
                public Builder profile(Canonical profile) {
                    this.profile = profile;
                    return this;
                }

                /**
                 * <p>
                 * Compartment Consistency Rules.
                 * </p>
                 * 
                 * @param compartment
                 *     Compartment Consistency Rules
                 * 
                 * @return
                 *     A reference to this Builder instance.
                 */
                public Builder compartment(Compartment... compartment) {
                    for (Compartment value : compartment) {
                        this.compartment.add(value);
                    }
                    return this;
                }

                /**
                 * <p>
                 * Compartment Consistency Rules.
                 * </p>
                 * 
                 * @param compartment
                 *     Compartment Consistency Rules
                 * 
                 * @return
                 *     A reference to this Builder instance.
                 */
                public Builder compartment(Collection<Compartment> compartment) {
                    this.compartment.addAll(compartment);
                    return this;
                }

                /**
                 * <p>
                 * Additional links from target resource.
                 * </p>
                 * 
                 * @param link
                 *     Additional links from target resource
                 * 
                 * @return
                 *     A reference to this Builder instance.
                 */
                public Builder link(GraphDefinition.Link... link) {
                    for (GraphDefinition.Link value : link) {
                        this.link.add(value);
                    }
                    return this;
                }

                /**
                 * <p>
                 * Additional links from target resource.
                 * </p>
                 * 
                 * @param link
                 *     Additional links from target resource
                 * 
                 * @return
                 *     A reference to this Builder instance.
                 */
                public Builder link(Collection<GraphDefinition.Link> link) {
                    this.link.addAll(link);
                    return this;
                }

                @Override
                public Target build() {
                    return new Target(this);
                }

                private static Builder from(Target target) {
                    Builder builder = new Builder(target.type);
                    builder.id = target.id;
                    builder.extension.addAll(target.extension);
                    builder.modifierExtension.addAll(target.modifierExtension);
                    builder.params = target.params;
                    builder.profile = target.profile;
                    builder.compartment.addAll(target.compartment);
                    builder.link.addAll(target.link);
                    return builder;
                }
            }

            /**
             * <p>
             * Compartment Consistency Rules.
             * </p>
             */
            public static class Compartment extends BackboneElement {
                private final GraphCompartmentUse use;
                private final CompartmentCode code;
                private final GraphCompartmentRule rule;
                private final String expression;
                private final String description;

                private Compartment(Builder builder) {
                    super(builder);
                    this.use = ValidationSupport.requireNonNull(builder.use, "use");
                    this.code = ValidationSupport.requireNonNull(builder.code, "code");
                    this.rule = ValidationSupport.requireNonNull(builder.rule, "rule");
                    this.expression = builder.expression;
                    this.description = builder.description;
                }

                /**
                 * <p>
                 * Defines how the compartment rule is used - whether it it is used to test whether resources are subject to the rule, or 
                 * whether it is a rule that must be followed.
                 * </p>
                 * 
                 * @return
                 *     An immutable object of type {@link GraphCompartmentUse}.
                 */
                public GraphCompartmentUse getUse() {
                    return use;
                }

                /**
                 * <p>
                 * Identifies the compartment.
                 * </p>
                 * 
                 * @return
                 *     An immutable object of type {@link CompartmentCode}.
                 */
                public CompartmentCode getCode() {
                    return code;
                }

                /**
                 * <p>
                 * identical | matching | different | no-rule | custom.
                 * </p>
                 * 
                 * @return
                 *     An immutable object of type {@link GraphCompartmentRule}.
                 */
                public GraphCompartmentRule getRule() {
                    return rule;
                }

                /**
                 * <p>
                 * Custom rule, as a FHIRPath expression.
                 * </p>
                 * 
                 * @return
                 *     An immutable object of type {@link String}.
                 */
                public String getExpression() {
                    return expression;
                }

                /**
                 * <p>
                 * Documentation for FHIRPath expression.
                 * </p>
                 * 
                 * @return
                 *     An immutable object of type {@link String}.
                 */
                public String getDescription() {
                    return description;
                }

                @Override
                public void accept(java.lang.String elementName, Visitor visitor) {
                    if (visitor.preVisit(this)) {
                        visitor.visitStart(elementName, this);
                        if (visitor.visit(elementName, this)) {
                            // visit children
                            accept(id, "id", visitor);
                            accept(extension, "extension", visitor, Extension.class);
                            accept(modifierExtension, "modifierExtension", visitor, Extension.class);
                            accept(use, "use", visitor);
                            accept(code, "code", visitor);
                            accept(rule, "rule", visitor);
                            accept(expression, "expression", visitor);
                            accept(description, "description", visitor);
                        }
                        visitor.visitEnd(elementName, this);
                        visitor.postVisit(this);
                    }
                }

                @Override
                public Builder toBuilder() {
                    return Builder.from(this);
                }

                public static Builder builder(GraphCompartmentUse use, CompartmentCode code, GraphCompartmentRule rule) {
                    return new Builder(use, code, rule);
                }

                public static class Builder extends BackboneElement.Builder {
                    // required
                    private final GraphCompartmentUse use;
                    private final CompartmentCode code;
                    private final GraphCompartmentRule rule;

                    // optional
                    private String expression;
                    private String description;

                    private Builder(GraphCompartmentUse use, CompartmentCode code, GraphCompartmentRule rule) {
                        super();
                        this.use = use;
                        this.code = code;
                        this.rule = rule;
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
                     * May be used to represent additional information that is not part of the basic definition of the element and that 
                     * modifies the understanding of the element in which it is contained and/or the understanding of the containing 
                     * element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe 
                     * and manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
                     * implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the 
                     * extension. Applications processing a resource are required to check for modifier extensions.
                     * </p>
                     * <p>
                     * Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
                     * change the meaning of modifierExtension itself).
                     * </p>
                     * 
                     * @param modifierExtension
                     *     Extensions that cannot be ignored even if unrecognized
                     * 
                     * @return
                     *     A reference to this Builder instance.
                     */
                    @Override
                    public Builder modifierExtension(Extension... modifierExtension) {
                        return (Builder) super.modifierExtension(modifierExtension);
                    }

                    /**
                     * <p>
                     * May be used to represent additional information that is not part of the basic definition of the element and that 
                     * modifies the understanding of the element in which it is contained and/or the understanding of the containing 
                     * element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe 
                     * and manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
                     * implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the 
                     * extension. Applications processing a resource are required to check for modifier extensions.
                     * </p>
                     * <p>
                     * Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
                     * change the meaning of modifierExtension itself).
                     * </p>
                     * 
                     * @param modifierExtension
                     *     Extensions that cannot be ignored even if unrecognized
                     * 
                     * @return
                     *     A reference to this Builder instance.
                     */
                    @Override
                    public Builder modifierExtension(Collection<Extension> modifierExtension) {
                        return (Builder) super.modifierExtension(modifierExtension);
                    }

                    /**
                     * <p>
                     * Custom rule, as a FHIRPath expression.
                     * </p>
                     * 
                     * @param expression
                     *     Custom rule, as a FHIRPath expression
                     * 
                     * @return
                     *     A reference to this Builder instance.
                     */
                    public Builder expression(String expression) {
                        this.expression = expression;
                        return this;
                    }

                    /**
                     * <p>
                     * Documentation for FHIRPath expression.
                     * </p>
                     * 
                     * @param description
                     *     Documentation for FHIRPath expression
                     * 
                     * @return
                     *     A reference to this Builder instance.
                     */
                    public Builder description(String description) {
                        this.description = description;
                        return this;
                    }

                    @Override
                    public Compartment build() {
                        return new Compartment(this);
                    }

                    private static Builder from(Compartment compartment) {
                        Builder builder = new Builder(compartment.use, compartment.code, compartment.rule);
                        builder.id = compartment.id;
                        builder.extension.addAll(compartment.extension);
                        builder.modifierExtension.addAll(compartment.modifierExtension);
                        builder.expression = compartment.expression;
                        builder.description = compartment.description;
                        return builder;
                    }
                }
            }
        }
    }
}