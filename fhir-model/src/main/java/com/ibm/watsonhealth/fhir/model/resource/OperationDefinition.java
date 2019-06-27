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
import com.ibm.watsonhealth.fhir.model.type.BindingStrength;
import com.ibm.watsonhealth.fhir.model.type.Boolean;
import com.ibm.watsonhealth.fhir.model.type.Canonical;
import com.ibm.watsonhealth.fhir.model.type.Code;
import com.ibm.watsonhealth.fhir.model.type.CodeableConcept;
import com.ibm.watsonhealth.fhir.model.type.ContactDetail;
import com.ibm.watsonhealth.fhir.model.type.DateTime;
import com.ibm.watsonhealth.fhir.model.type.Extension;
import com.ibm.watsonhealth.fhir.model.type.FHIRAllTypes;
import com.ibm.watsonhealth.fhir.model.type.Id;
import com.ibm.watsonhealth.fhir.model.type.Integer;
import com.ibm.watsonhealth.fhir.model.type.Markdown;
import com.ibm.watsonhealth.fhir.model.type.Meta;
import com.ibm.watsonhealth.fhir.model.type.Narrative;
import com.ibm.watsonhealth.fhir.model.type.OperationKind;
import com.ibm.watsonhealth.fhir.model.type.OperationParameterUse;
import com.ibm.watsonhealth.fhir.model.type.PublicationStatus;
import com.ibm.watsonhealth.fhir.model.type.ResourceType;
import com.ibm.watsonhealth.fhir.model.type.SearchParamType;
import com.ibm.watsonhealth.fhir.model.type.String;
import com.ibm.watsonhealth.fhir.model.type.Uri;
import com.ibm.watsonhealth.fhir.model.type.UsageContext;
import com.ibm.watsonhealth.fhir.model.util.ValidationSupport;
import com.ibm.watsonhealth.fhir.model.visitor.Visitor;

/**
 * <p>
 * A formal computable definition of an operation (on the RESTful interface) or a named query (using the search 
 * interaction).
 * </p>
 */
@Constraint(
    key = "opd-0",
    severity = "warning",
    human = "Name should be usable as an identifier for the module by machine processing applications such as code generation",
    expression = "name.matches('[A-Z]([A-Za-z0-9_]){0,254}')"
)
@Generated("com.ibm.watsonhealth.fhir.tools.CodeGenerator")
public class OperationDefinition extends DomainResource {
    private final Uri url;
    private final String version;
    private final String name;
    private final String title;
    private final PublicationStatus status;
    private final OperationKind kind;
    private final Boolean experimental;
    private final DateTime date;
    private final String publisher;
    private final List<ContactDetail> contact;
    private final Markdown description;
    private final List<UsageContext> useContext;
    private final List<CodeableConcept> jurisdiction;
    private final Markdown purpose;
    private final Boolean affectsState;
    private final Code code;
    private final Markdown comment;
    private final Canonical base;
    private final List<ResourceType> resource;
    private final Boolean system;
    private final Boolean type;
    private final Boolean instance;
    private final Canonical inputProfile;
    private final Canonical outputProfile;
    private final List<Parameter> parameter;
    private final List<Overload> overload;

    private OperationDefinition(Builder builder) {
        super(builder);
        this.url = builder.url;
        this.version = builder.version;
        this.name = ValidationSupport.requireNonNull(builder.name, "name");
        this.title = builder.title;
        this.status = ValidationSupport.requireNonNull(builder.status, "status");
        this.kind = ValidationSupport.requireNonNull(builder.kind, "kind");
        this.experimental = builder.experimental;
        this.date = builder.date;
        this.publisher = builder.publisher;
        this.contact = builder.contact;
        this.description = builder.description;
        this.useContext = builder.useContext;
        this.jurisdiction = builder.jurisdiction;
        this.purpose = builder.purpose;
        this.affectsState = builder.affectsState;
        this.code = ValidationSupport.requireNonNull(builder.code, "code");
        this.comment = builder.comment;
        this.base = builder.base;
        this.resource = builder.resource;
        this.system = ValidationSupport.requireNonNull(builder.system, "system");
        this.type = ValidationSupport.requireNonNull(builder.type, "type");
        this.instance = ValidationSupport.requireNonNull(builder.instance, "instance");
        this.inputProfile = builder.inputProfile;
        this.outputProfile = builder.outputProfile;
        this.parameter = builder.parameter;
        this.overload = builder.overload;
    }

    /**
     * <p>
     * An absolute URI that is used to identify this operation definition when it is referenced in a specification, model, 
     * design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal 
     * address at which at which an authoritative instance of this operation definition is (or will be) published. This URL 
     * can be the target of a canonical reference. It SHALL remain the same when the operation definition is stored on 
     * different servers.
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
     * The identifier that is used to identify this version of the operation definition when it is referenced in a 
     * specification, model, design or instance. This is an arbitrary value managed by the operation definition author and is 
     * not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not 
     * available. There is also no expectation that versions can be placed in a lexicographical sequence.
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
     * A natural language name identifying the operation definition. This name should be usable as an identifier for the 
     * module by machine processing applications such as code generation.
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
     * A short, descriptive, user-friendly title for the operation definition.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link String}.
     */
    public String getTitle() {
        return title;
    }

    /**
     * <p>
     * The status of this operation definition. Enables tracking the life-cycle of the content.
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
     * Whether this is an operation or a named query.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link OperationKind}.
     */
    public OperationKind getKind() {
        return kind;
    }

    /**
     * <p>
     * A Boolean value to indicate that this operation definition is authored for testing purposes (or 
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
     * The date (and optionally time) when the operation definition was published. The date must change when the business 
     * version changes and it must change if the status code changes. In addition, it should change when the substantive 
     * content of the operation definition changes.
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
     * The name of the organization or individual that published the operation definition.
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
     * A free text natural language description of the operation definition from a consumer's perspective.
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
     * may be used to assist with indexing and searching for appropriate operation definition instances.
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
     * A legal or geographic region in which the operation definition is intended to be used.
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
     * Explanation of why this operation definition is needed and why it has been designed as it has.
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
     * Whether the operation affects state. Side effects such as producing audit trail entries do not count as 'affecting 
     * state'.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link Boolean}.
     */
    public Boolean getAffectsState() {
        return affectsState;
    }

    /**
     * <p>
     * The name used to invoke the operation.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link Code}.
     */
    public Code getCode() {
        return code;
    }

    /**
     * <p>
     * Additional information about how to use this operation or named query.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link Markdown}.
     */
    public Markdown getComment() {
        return comment;
    }

    /**
     * <p>
     * Indicates that this operation definition is a constraining profile on the base.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link Canonical}.
     */
    public Canonical getBase() {
        return base;
    }

    /**
     * <p>
     * The types on which this operation can be executed.
     * </p>
     * 
     * @return
     *     A list containing immutable objects of type {@link ResourceType}.
     */
    public List<ResourceType> getResource() {
        return resource;
    }

    /**
     * <p>
     * Indicates whether this operation or named query can be invoked at the system level (e.g. without needing to choose a 
     * resource type for the context).
     * </p>
     * 
     * @return
     *     An immutable object of type {@link Boolean}.
     */
    public Boolean getSystem() {
        return system;
    }

    /**
     * <p>
     * Indicates whether this operation or named query can be invoked at the resource type level for any given resource type 
     * level (e.g. without needing to choose a specific resource id for the context).
     * </p>
     * 
     * @return
     *     An immutable object of type {@link Boolean}.
     */
    public Boolean getType() {
        return type;
    }

    /**
     * <p>
     * Indicates whether this operation can be invoked on a particular instance of one of the given types.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link Boolean}.
     */
    public Boolean getInstance() {
        return instance;
    }

    /**
     * <p>
     * Additional validation information for the in parameters - a single profile that covers all the parameters. The profile 
     * is a constraint on the parameters resource as a whole.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link Canonical}.
     */
    public Canonical getInputProfile() {
        return inputProfile;
    }

    /**
     * <p>
     * Additional validation information for the out parameters - a single profile that covers all the parameters. The 
     * profile is a constraint on the parameters resource.
     * </p>
     * 
     * @return
     *     An immutable object of type {@link Canonical}.
     */
    public Canonical getOutputProfile() {
        return outputProfile;
    }

    /**
     * <p>
     * The parameters for the operation/query.
     * </p>
     * 
     * @return
     *     A list containing immutable objects of type {@link Parameter}.
     */
    public List<Parameter> getParameter() {
        return parameter;
    }

    /**
     * <p>
     * Defines an appropriate combination of parameters to use when invoking this operation, to help code generators when 
     * generating overloaded parameter sets for this operation.
     * </p>
     * 
     * @return
     *     A list containing immutable objects of type {@link Overload}.
     */
    public List<Overload> getOverload() {
        return overload;
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
                accept(title, "title", visitor);
                accept(status, "status", visitor);
                accept(kind, "kind", visitor);
                accept(experimental, "experimental", visitor);
                accept(date, "date", visitor);
                accept(publisher, "publisher", visitor);
                accept(contact, "contact", visitor, ContactDetail.class);
                accept(description, "description", visitor);
                accept(useContext, "useContext", visitor, UsageContext.class);
                accept(jurisdiction, "jurisdiction", visitor, CodeableConcept.class);
                accept(purpose, "purpose", visitor);
                accept(affectsState, "affectsState", visitor);
                accept(code, "code", visitor);
                accept(comment, "comment", visitor);
                accept(base, "base", visitor);
                accept(resource, "resource", visitor, ResourceType.class);
                accept(system, "system", visitor);
                accept(type, "type", visitor);
                accept(instance, "instance", visitor);
                accept(inputProfile, "inputProfile", visitor);
                accept(outputProfile, "outputProfile", visitor);
                accept(parameter, "parameter", visitor, Parameter.class);
                accept(overload, "overload", visitor, Overload.class);
            }
            visitor.visitEnd(elementName, this);
            visitor.postVisit(this);
        }
    }

    @Override
    public Builder toBuilder() {
        Builder builder = new Builder(name, status, kind, code, system, type, instance);
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
        builder.title = title;
        builder.experimental = experimental;
        builder.date = date;
        builder.publisher = publisher;
        builder.contact.addAll(contact);
        builder.description = description;
        builder.useContext.addAll(useContext);
        builder.jurisdiction.addAll(jurisdiction);
        builder.purpose = purpose;
        builder.affectsState = affectsState;
        builder.comment = comment;
        builder.base = base;
        builder.resource.addAll(resource);
        builder.inputProfile = inputProfile;
        builder.outputProfile = outputProfile;
        builder.parameter.addAll(parameter);
        builder.overload.addAll(overload);
        return builder;
    }

    public static Builder builder(String name, PublicationStatus status, OperationKind kind, Code code, Boolean system, Boolean type, Boolean instance) {
        return new Builder(name, status, kind, code, system, type, instance);
    }

    public static class Builder extends DomainResource.Builder {
        // required
        private final String name;
        private final PublicationStatus status;
        private final OperationKind kind;
        private final Code code;
        private final Boolean system;
        private final Boolean type;
        private final Boolean instance;

        // optional
        private Uri url;
        private String version;
        private String title;
        private Boolean experimental;
        private DateTime date;
        private String publisher;
        private List<ContactDetail> contact = new ArrayList<>();
        private Markdown description;
        private List<UsageContext> useContext = new ArrayList<>();
        private List<CodeableConcept> jurisdiction = new ArrayList<>();
        private Markdown purpose;
        private Boolean affectsState;
        private Markdown comment;
        private Canonical base;
        private List<ResourceType> resource = new ArrayList<>();
        private Canonical inputProfile;
        private Canonical outputProfile;
        private List<Parameter> parameter = new ArrayList<>();
        private List<Overload> overload = new ArrayList<>();

        private Builder(String name, PublicationStatus status, OperationKind kind, Code code, Boolean system, Boolean type, Boolean instance) {
            super();
            this.name = name;
            this.status = status;
            this.kind = kind;
            this.code = code;
            this.system = system;
            this.type = type;
            this.instance = instance;
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
         * An absolute URI that is used to identify this operation definition when it is referenced in a specification, model, 
         * design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal 
         * address at which at which an authoritative instance of this operation definition is (or will be) published. This URL 
         * can be the target of a canonical reference. It SHALL remain the same when the operation definition is stored on 
         * different servers.
         * </p>
         * 
         * @param url
         *     Canonical identifier for this operation definition, represented as a URI (globally unique)
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
         * The identifier that is used to identify this version of the operation definition when it is referenced in a 
         * specification, model, design or instance. This is an arbitrary value managed by the operation definition author and is 
         * not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not 
         * available. There is also no expectation that versions can be placed in a lexicographical sequence.
         * </p>
         * 
         * @param version
         *     Business version of the operation definition
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
         * A short, descriptive, user-friendly title for the operation definition.
         * </p>
         * 
         * @param title
         *     Name for this operation definition (human friendly)
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder title(String title) {
            this.title = title;
            return this;
        }

        /**
         * <p>
         * A Boolean value to indicate that this operation definition is authored for testing purposes (or 
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
         * The date (and optionally time) when the operation definition was published. The date must change when the business 
         * version changes and it must change if the status code changes. In addition, it should change when the substantive 
         * content of the operation definition changes.
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
         * The name of the organization or individual that published the operation definition.
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
         * A free text natural language description of the operation definition from a consumer's perspective.
         * </p>
         * 
         * @param description
         *     Natural language description of the operation definition
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
         * may be used to assist with indexing and searching for appropriate operation definition instances.
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
         * may be used to assist with indexing and searching for appropriate operation definition instances.
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
         * A legal or geographic region in which the operation definition is intended to be used.
         * </p>
         * 
         * @param jurisdiction
         *     Intended jurisdiction for operation definition (if applicable)
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
         * A legal or geographic region in which the operation definition is intended to be used.
         * </p>
         * 
         * @param jurisdiction
         *     Intended jurisdiction for operation definition (if applicable)
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
         * Explanation of why this operation definition is needed and why it has been designed as it has.
         * </p>
         * 
         * @param purpose
         *     Why this operation definition is defined
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
         * Whether the operation affects state. Side effects such as producing audit trail entries do not count as 'affecting 
         * state'.
         * </p>
         * 
         * @param affectsState
         *     Whether content is changed by the operation
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder affectsState(Boolean affectsState) {
            this.affectsState = affectsState;
            return this;
        }

        /**
         * <p>
         * Additional information about how to use this operation or named query.
         * </p>
         * 
         * @param comment
         *     Additional information about use
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder comment(Markdown comment) {
            this.comment = comment;
            return this;
        }

        /**
         * <p>
         * Indicates that this operation definition is a constraining profile on the base.
         * </p>
         * 
         * @param base
         *     Marks this as a profile of the base
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder base(Canonical base) {
            this.base = base;
            return this;
        }

        /**
         * <p>
         * The types on which this operation can be executed.
         * </p>
         * 
         * @param resource
         *     Types this operation applies to
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder resource(ResourceType... resource) {
            for (ResourceType value : resource) {
                this.resource.add(value);
            }
            return this;
        }

        /**
         * <p>
         * The types on which this operation can be executed.
         * </p>
         * 
         * @param resource
         *     Types this operation applies to
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder resource(Collection<ResourceType> resource) {
            this.resource.addAll(resource);
            return this;
        }

        /**
         * <p>
         * Additional validation information for the in parameters - a single profile that covers all the parameters. The profile 
         * is a constraint on the parameters resource as a whole.
         * </p>
         * 
         * @param inputProfile
         *     Validation information for in parameters
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder inputProfile(Canonical inputProfile) {
            this.inputProfile = inputProfile;
            return this;
        }

        /**
         * <p>
         * Additional validation information for the out parameters - a single profile that covers all the parameters. The 
         * profile is a constraint on the parameters resource.
         * </p>
         * 
         * @param outputProfile
         *     Validation information for out parameters
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder outputProfile(Canonical outputProfile) {
            this.outputProfile = outputProfile;
            return this;
        }

        /**
         * <p>
         * The parameters for the operation/query.
         * </p>
         * 
         * @param parameter
         *     Parameters for the operation/query
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder parameter(Parameter... parameter) {
            for (Parameter value : parameter) {
                this.parameter.add(value);
            }
            return this;
        }

        /**
         * <p>
         * The parameters for the operation/query.
         * </p>
         * 
         * @param parameter
         *     Parameters for the operation/query
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder parameter(Collection<Parameter> parameter) {
            this.parameter.addAll(parameter);
            return this;
        }

        /**
         * <p>
         * Defines an appropriate combination of parameters to use when invoking this operation, to help code generators when 
         * generating overloaded parameter sets for this operation.
         * </p>
         * 
         * @param overload
         *     Define overloaded variants for when generating code
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder overload(Overload... overload) {
            for (Overload value : overload) {
                this.overload.add(value);
            }
            return this;
        }

        /**
         * <p>
         * Defines an appropriate combination of parameters to use when invoking this operation, to help code generators when 
         * generating overloaded parameter sets for this operation.
         * </p>
         * 
         * @param overload
         *     Define overloaded variants for when generating code
         * 
         * @return
         *     A reference to this Builder instance.
         */
        public Builder overload(Collection<Overload> overload) {
            this.overload.addAll(overload);
            return this;
        }

        @Override
        public OperationDefinition build() {
            return new OperationDefinition(this);
        }
    }

    /**
     * <p>
     * The parameters for the operation/query.
     * </p>
     */
    public static class Parameter extends BackboneElement {
        private final Code name;
        private final OperationParameterUse use;
        private final Integer min;
        private final String max;
        private final String documentation;
        private final FHIRAllTypes type;
        private final List<Canonical> targetProfile;
        private final SearchParamType searchType;
        private final Binding binding;
        private final List<ReferencedFrom> referencedFrom;
        private final List<OperationDefinition.Parameter> part;

        private Parameter(Builder builder) {
            super(builder);
            this.name = ValidationSupport.requireNonNull(builder.name, "name");
            this.use = ValidationSupport.requireNonNull(builder.use, "use");
            this.min = ValidationSupport.requireNonNull(builder.min, "min");
            this.max = ValidationSupport.requireNonNull(builder.max, "max");
            this.documentation = builder.documentation;
            this.type = builder.type;
            this.targetProfile = builder.targetProfile;
            this.searchType = builder.searchType;
            this.binding = builder.binding;
            this.referencedFrom = builder.referencedFrom;
            this.part = builder.part;
        }

        /**
         * <p>
         * The name of used to identify the parameter.
         * </p>
         * 
         * @return
         *     An immutable object of type {@link Code}.
         */
        public Code getName() {
            return name;
        }

        /**
         * <p>
         * Whether this is an input or an output parameter.
         * </p>
         * 
         * @return
         *     An immutable object of type {@link OperationParameterUse}.
         */
        public OperationParameterUse getUse() {
            return use;
        }

        /**
         * <p>
         * The minimum number of times this parameter SHALL appear in the request or response.
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
         * The maximum number of times this element is permitted to appear in the request or response.
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
         * Describes the meaning or use of this parameter.
         * </p>
         * 
         * @return
         *     An immutable object of type {@link String}.
         */
        public String getDocumentation() {
            return documentation;
        }

        /**
         * <p>
         * The type for this parameter.
         * </p>
         * 
         * @return
         *     An immutable object of type {@link FHIRAllTypes}.
         */
        public FHIRAllTypes getType() {
            return type;
        }

        /**
         * <p>
         * Used when the type is "Reference" or "canonical", and identifies a profile structure or implementation Guide that 
         * applies to the target of the reference this parameter refers to. If any profiles are specified, then the content must 
         * conform to at least one of them. The URL can be a local reference - to a contained StructureDefinition, or a reference 
         * to another StructureDefinition or Implementation Guide by a canonical URL. When an implementation guide is specified, 
         * the target resource SHALL conform to at least one profile defined in the implementation guide.
         * </p>
         * 
         * @return
         *     A list containing immutable objects of type {@link Canonical}.
         */
        public List<Canonical> getTargetProfile() {
            return targetProfile;
        }

        /**
         * <p>
         * How the parameter is understood as a search parameter. This is only used if the parameter type is 'string'.
         * </p>
         * 
         * @return
         *     An immutable object of type {@link SearchParamType}.
         */
        public SearchParamType getSearchType() {
            return searchType;
        }

        /**
         * <p>
         * Binds to a value set if this parameter is coded (code, Coding, CodeableConcept).
         * </p>
         * 
         * @return
         *     An immutable object of type {@link Binding}.
         */
        public Binding getBinding() {
            return binding;
        }

        /**
         * <p>
         * Identifies other resource parameters within the operation invocation that are expected to resolve to this resource.
         * </p>
         * 
         * @return
         *     A list containing immutable objects of type {@link ReferencedFrom}.
         */
        public List<ReferencedFrom> getReferencedFrom() {
            return referencedFrom;
        }

        /**
         * <p>
         * The parts of a nested Parameter.
         * </p>
         * 
         * @return
         *     A list containing immutable objects of type {@link Parameter}.
         */
        public List<OperationDefinition.Parameter> getPart() {
            return part;
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
                    accept(name, "name", visitor);
                    accept(use, "use", visitor);
                    accept(min, "min", visitor);
                    accept(max, "max", visitor);
                    accept(documentation, "documentation", visitor);
                    accept(type, "type", visitor);
                    accept(targetProfile, "targetProfile", visitor, Canonical.class);
                    accept(searchType, "searchType", visitor);
                    accept(binding, "binding", visitor);
                    accept(referencedFrom, "referencedFrom", visitor, ReferencedFrom.class);
                    accept(part, "part", visitor, OperationDefinition.Parameter.class);
                }
                visitor.visitEnd(elementName, this);
                visitor.postVisit(this);
            }
        }

        @Override
        public Builder toBuilder() {
            return Builder.from(this);
        }

        public static Builder builder(Code name, OperationParameterUse use, Integer min, String max) {
            return new Builder(name, use, min, max);
        }

        public static class Builder extends BackboneElement.Builder {
            // required
            private final Code name;
            private final OperationParameterUse use;
            private final Integer min;
            private final String max;

            // optional
            private String documentation;
            private FHIRAllTypes type;
            private List<Canonical> targetProfile = new ArrayList<>();
            private SearchParamType searchType;
            private Binding binding;
            private List<ReferencedFrom> referencedFrom = new ArrayList<>();
            private List<OperationDefinition.Parameter> part = new ArrayList<>();

            private Builder(Code name, OperationParameterUse use, Integer min, String max) {
                super();
                this.name = name;
                this.use = use;
                this.min = min;
                this.max = max;
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
             * Describes the meaning or use of this parameter.
             * </p>
             * 
             * @param documentation
             *     Description of meaning/use
             * 
             * @return
             *     A reference to this Builder instance.
             */
            public Builder documentation(String documentation) {
                this.documentation = documentation;
                return this;
            }

            /**
             * <p>
             * The type for this parameter.
             * </p>
             * 
             * @param type
             *     What type this parameter has
             * 
             * @return
             *     A reference to this Builder instance.
             */
            public Builder type(FHIRAllTypes type) {
                this.type = type;
                return this;
            }

            /**
             * <p>
             * Used when the type is "Reference" or "canonical", and identifies a profile structure or implementation Guide that 
             * applies to the target of the reference this parameter refers to. If any profiles are specified, then the content must 
             * conform to at least one of them. The URL can be a local reference - to a contained StructureDefinition, or a reference 
             * to another StructureDefinition or Implementation Guide by a canonical URL. When an implementation guide is specified, 
             * the target resource SHALL conform to at least one profile defined in the implementation guide.
             * </p>
             * 
             * @param targetProfile
             *     If type is Reference | canonical, allowed targets
             * 
             * @return
             *     A reference to this Builder instance.
             */
            public Builder targetProfile(Canonical... targetProfile) {
                for (Canonical value : targetProfile) {
                    this.targetProfile.add(value);
                }
                return this;
            }

            /**
             * <p>
             * Used when the type is "Reference" or "canonical", and identifies a profile structure or implementation Guide that 
             * applies to the target of the reference this parameter refers to. If any profiles are specified, then the content must 
             * conform to at least one of them. The URL can be a local reference - to a contained StructureDefinition, or a reference 
             * to another StructureDefinition or Implementation Guide by a canonical URL. When an implementation guide is specified, 
             * the target resource SHALL conform to at least one profile defined in the implementation guide.
             * </p>
             * 
             * @param targetProfile
             *     If type is Reference | canonical, allowed targets
             * 
             * @return
             *     A reference to this Builder instance.
             */
            public Builder targetProfile(Collection<Canonical> targetProfile) {
                this.targetProfile.addAll(targetProfile);
                return this;
            }

            /**
             * <p>
             * How the parameter is understood as a search parameter. This is only used if the parameter type is 'string'.
             * </p>
             * 
             * @param searchType
             *     number | date | string | token | reference | composite | quantity | uri | special
             * 
             * @return
             *     A reference to this Builder instance.
             */
            public Builder searchType(SearchParamType searchType) {
                this.searchType = searchType;
                return this;
            }

            /**
             * <p>
             * Binds to a value set if this parameter is coded (code, Coding, CodeableConcept).
             * </p>
             * 
             * @param binding
             *     ValueSet details if this is coded
             * 
             * @return
             *     A reference to this Builder instance.
             */
            public Builder binding(Binding binding) {
                this.binding = binding;
                return this;
            }

            /**
             * <p>
             * Identifies other resource parameters within the operation invocation that are expected to resolve to this resource.
             * </p>
             * 
             * @param referencedFrom
             *     References to this parameter
             * 
             * @return
             *     A reference to this Builder instance.
             */
            public Builder referencedFrom(ReferencedFrom... referencedFrom) {
                for (ReferencedFrom value : referencedFrom) {
                    this.referencedFrom.add(value);
                }
                return this;
            }

            /**
             * <p>
             * Identifies other resource parameters within the operation invocation that are expected to resolve to this resource.
             * </p>
             * 
             * @param referencedFrom
             *     References to this parameter
             * 
             * @return
             *     A reference to this Builder instance.
             */
            public Builder referencedFrom(Collection<ReferencedFrom> referencedFrom) {
                this.referencedFrom.addAll(referencedFrom);
                return this;
            }

            /**
             * <p>
             * The parts of a nested Parameter.
             * </p>
             * 
             * @param part
             *     Parts of a nested Parameter
             * 
             * @return
             *     A reference to this Builder instance.
             */
            public Builder part(OperationDefinition.Parameter... part) {
                for (OperationDefinition.Parameter value : part) {
                    this.part.add(value);
                }
                return this;
            }

            /**
             * <p>
             * The parts of a nested Parameter.
             * </p>
             * 
             * @param part
             *     Parts of a nested Parameter
             * 
             * @return
             *     A reference to this Builder instance.
             */
            public Builder part(Collection<OperationDefinition.Parameter> part) {
                this.part.addAll(part);
                return this;
            }

            @Override
            public Parameter build() {
                return new Parameter(this);
            }

            private static Builder from(Parameter parameter) {
                Builder builder = new Builder(parameter.name, parameter.use, parameter.min, parameter.max);
                builder.id = parameter.id;
                builder.extension.addAll(parameter.extension);
                builder.modifierExtension.addAll(parameter.modifierExtension);
                builder.documentation = parameter.documentation;
                builder.type = parameter.type;
                builder.targetProfile.addAll(parameter.targetProfile);
                builder.searchType = parameter.searchType;
                builder.binding = parameter.binding;
                builder.referencedFrom.addAll(parameter.referencedFrom);
                builder.part.addAll(parameter.part);
                return builder;
            }
        }

        /**
         * <p>
         * Binds to a value set if this parameter is coded (code, Coding, CodeableConcept).
         * </p>
         */
        public static class Binding extends BackboneElement {
            private final BindingStrength strength;
            private final Canonical valueSet;

            private Binding(Builder builder) {
                super(builder);
                this.strength = ValidationSupport.requireNonNull(builder.strength, "strength");
                this.valueSet = ValidationSupport.requireNonNull(builder.valueSet, "valueSet");
            }

            /**
             * <p>
             * Indicates the degree of conformance expectations associated with this binding - that is, the degree to which the 
             * provided value set must be adhered to in the instances.
             * </p>
             * 
             * @return
             *     An immutable object of type {@link BindingStrength}.
             */
            public BindingStrength getStrength() {
                return strength;
            }

            /**
             * <p>
             * Points to the value set or external definition (e.g. implicit value set) that identifies the set of codes to be used.
             * </p>
             * 
             * @return
             *     An immutable object of type {@link Canonical}.
             */
            public Canonical getValueSet() {
                return valueSet;
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
                        accept(strength, "strength", visitor);
                        accept(valueSet, "valueSet", visitor);
                    }
                    visitor.visitEnd(elementName, this);
                    visitor.postVisit(this);
                }
            }

            @Override
            public Builder toBuilder() {
                return Builder.from(this);
            }

            public static Builder builder(BindingStrength strength, Canonical valueSet) {
                return new Builder(strength, valueSet);
            }

            public static class Builder extends BackboneElement.Builder {
                // required
                private final BindingStrength strength;
                private final Canonical valueSet;

                private Builder(BindingStrength strength, Canonical valueSet) {
                    super();
                    this.strength = strength;
                    this.valueSet = valueSet;
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

                @Override
                public Binding build() {
                    return new Binding(this);
                }

                private static Builder from(Binding binding) {
                    Builder builder = new Builder(binding.strength, binding.valueSet);
                    builder.id = binding.id;
                    builder.extension.addAll(binding.extension);
                    builder.modifierExtension.addAll(binding.modifierExtension);
                    return builder;
                }
            }
        }

        /**
         * <p>
         * Identifies other resource parameters within the operation invocation that are expected to resolve to this resource.
         * </p>
         */
        public static class ReferencedFrom extends BackboneElement {
            private final String source;
            private final String sourceId;

            private ReferencedFrom(Builder builder) {
                super(builder);
                this.source = ValidationSupport.requireNonNull(builder.source, "source");
                this.sourceId = builder.sourceId;
            }

            /**
             * <p>
             * The name of the parameter or dot-separated path of parameter names pointing to the resource parameter that is expected 
             * to contain a reference to this resource.
             * </p>
             * 
             * @return
             *     An immutable object of type {@link String}.
             */
            public String getSource() {
                return source;
            }

            /**
             * <p>
             * The id of the element in the referencing resource that is expected to resolve to this resource.
             * </p>
             * 
             * @return
             *     An immutable object of type {@link String}.
             */
            public String getSourceId() {
                return sourceId;
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
                        accept(source, "source", visitor);
                        accept(sourceId, "sourceId", visitor);
                    }
                    visitor.visitEnd(elementName, this);
                    visitor.postVisit(this);
                }
            }

            @Override
            public Builder toBuilder() {
                return Builder.from(this);
            }

            public static Builder builder(String source) {
                return new Builder(source);
            }

            public static class Builder extends BackboneElement.Builder {
                // required
                private final String source;

                // optional
                private String sourceId;

                private Builder(String source) {
                    super();
                    this.source = source;
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
                 * The id of the element in the referencing resource that is expected to resolve to this resource.
                 * </p>
                 * 
                 * @param sourceId
                 *     Element id of reference
                 * 
                 * @return
                 *     A reference to this Builder instance.
                 */
                public Builder sourceId(String sourceId) {
                    this.sourceId = sourceId;
                    return this;
                }

                @Override
                public ReferencedFrom build() {
                    return new ReferencedFrom(this);
                }

                private static Builder from(ReferencedFrom referencedFrom) {
                    Builder builder = new Builder(referencedFrom.source);
                    builder.id = referencedFrom.id;
                    builder.extension.addAll(referencedFrom.extension);
                    builder.modifierExtension.addAll(referencedFrom.modifierExtension);
                    builder.sourceId = referencedFrom.sourceId;
                    return builder;
                }
            }
        }
    }

    /**
     * <p>
     * Defines an appropriate combination of parameters to use when invoking this operation, to help code generators when 
     * generating overloaded parameter sets for this operation.
     * </p>
     */
    public static class Overload extends BackboneElement {
        private final List<String> parameterName;
        private final String comment;

        private Overload(Builder builder) {
            super(builder);
            this.parameterName = builder.parameterName;
            this.comment = builder.comment;
        }

        /**
         * <p>
         * Name of parameter to include in overload.
         * </p>
         * 
         * @return
         *     A list containing immutable objects of type {@link String}.
         */
        public List<String> getParameterName() {
            return parameterName;
        }

        /**
         * <p>
         * Comments to go on overload.
         * </p>
         * 
         * @return
         *     An immutable object of type {@link String}.
         */
        public String getComment() {
            return comment;
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
                    accept(parameterName, "parameterName", visitor, String.class);
                    accept(comment, "comment", visitor);
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
            private List<String> parameterName = new ArrayList<>();
            private String comment;

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
             * Name of parameter to include in overload.
             * </p>
             * 
             * @param parameterName
             *     Name of parameter to include in overload
             * 
             * @return
             *     A reference to this Builder instance.
             */
            public Builder parameterName(String... parameterName) {
                for (String value : parameterName) {
                    this.parameterName.add(value);
                }
                return this;
            }

            /**
             * <p>
             * Name of parameter to include in overload.
             * </p>
             * 
             * @param parameterName
             *     Name of parameter to include in overload
             * 
             * @return
             *     A reference to this Builder instance.
             */
            public Builder parameterName(Collection<String> parameterName) {
                this.parameterName.addAll(parameterName);
                return this;
            }

            /**
             * <p>
             * Comments to go on overload.
             * </p>
             * 
             * @param comment
             *     Comments to go on overload
             * 
             * @return
             *     A reference to this Builder instance.
             */
            public Builder comment(String comment) {
                this.comment = comment;
                return this;
            }

            @Override
            public Overload build() {
                return new Overload(this);
            }

            private static Builder from(Overload overload) {
                Builder builder = new Builder();
                builder.id = overload.id;
                builder.extension.addAll(overload.extension);
                builder.modifierExtension.addAll(overload.modifierExtension);
                builder.parameterName.addAll(overload.parameterName);
                builder.comment = overload.comment;
                return builder;
            }
        }
    }
}