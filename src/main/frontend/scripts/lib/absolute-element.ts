import { registerLicense } from "@syncfusion/ej2-base";
import { LitElement } from "lit";
import { customElement } from "lit/decorators.js";

@customElement('absolute-element')
export class AbsoluteElement extends LitElement {
    constructor() {
        super();
        registerLicense('Ngo9BigBOggjHTQxAR8/V1NCaF5cXmZCf1FpRmJGdld5fUVHYVZUTXxaS00DNHVRdkdnWXlcdXRXRGNdUEZ+XkA=');
    }
}