import { SET_UPLOAD_MESSAGE, CLEAR_UPLOAD_MESSAGE } from "../actions/types";

const initialState = {
    message: "",
};

export default function (state = initialState, action) {
    const { type, payload } = action;

    switch (type) {
        case SET_UPLOAD_MESSAGE:
            return {
                message: payload.message,
            };

        case CLEAR_UPLOAD_MESSAGE:
            return {
                message: "",
            };

        default:
            return state;
    }
}
