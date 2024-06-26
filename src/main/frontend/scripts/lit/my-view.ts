import { html, LitElement } from 'lit';
import { customElement } from 'lit/decorators.js';
import '@vaadin/button';
import { Notification } from '@vaadin/notification';

@customElement('my-view')
export class MyView extends LitElement {
    render() {
        return html`<vaadin-button @click="${this.sayHello}">Say hello</vaadin-button>`;
    }

    private sayHello() {
        Notification.show('Hello');
    }
}