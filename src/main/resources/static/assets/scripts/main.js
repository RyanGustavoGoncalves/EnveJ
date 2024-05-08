import { EnveJID } from "../../enveJModule/services/EnveJ.service.js";
import { EnveJConfig } from "../../enveJModule/services/EnveJConfig.service.js";

const socketConfig = new EnveJConfig("ws://localhost:8080/socket");
const enveJID = new EnveJID();

let inputField = enveJID.getField("field");
const btn = enveJID.getField("btn").addEventListener("click", () => {
    socketConfig.sendMessage(inputField.value);
});