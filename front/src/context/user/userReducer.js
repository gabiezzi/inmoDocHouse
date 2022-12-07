import { TYPES } from "../types";

export const userReducer = (state, action) => {
 
    const { type, payload } = action;

    switch(type) {
        case TYPES.SAVE_TOKEN:
            return{
                ...state,
                token:`Bearer ${payload.accessToken}`,
                inSession:true,
                username: payload.usernameOrEmail,
            }
        case TYPES.LOGOUT:
            return{
                ...state,
                token: undefined,
                inSession: false,
            }

    }
}
