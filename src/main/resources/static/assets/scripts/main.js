import { EnveJID } from "../../../enveJModule/services/EnveJID.js";

const enveJID = new EnveJID();

let inputField = enveJID.getField("field");
const btn = enveJID.getField("btn").addEventListener("click", () => {
    console.log(inputField.value);
});