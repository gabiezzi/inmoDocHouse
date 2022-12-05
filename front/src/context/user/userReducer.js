import { TYPES } from "../types";

export const userReducer = (state, action) => {
 
    const { type, payload } = action;
    const { user } = state;

    switch(type) {
        case TYPES.SAVE_TOKEN:
            return{
                ...state,
                token:`Bearer ${payload.accessToken}`
            }
    }
}
