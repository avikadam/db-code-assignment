import { combineReducers } from "redux";
import auth from "./auth";
import message from "./message";
import upload from "./upload";

export default combineReducers({
  auth,
  message,
  upload,
});
