import {
    SET_UPLOAD_MESSAGE,
    CLEAR_UPLOAD_MESSAGE,
} from "./types";

export const setUploadMessage = (message) => ({
    type: SET_UPLOAD_MESSAGE,
    payload: message
});

export const clearUploadMessage = () => ({
    type: CLEAR_UPLOAD_MESSAGE,
});