import { TYPES } from "../types";

export const userReducer = (state, action) => {
 
    const { type, payload } = action;

    switch(type) {
        case TYPES.SAVE_TOKEN:
            return{
                ...state,
                token:`Bearer ${payload.token}`,
                inSession:true,
                username: payload.username,
            }
        case TYPES.LOGOUT:
            return{
                ...state,
                token: undefined,
                inSession: false,
            }

    }
}
