// services/EnveJID.js
export class EnveJID {
    getField(component) {
        let value = document.querySelector(`[env-id="${component}"]`);
        return value;
    }
}
