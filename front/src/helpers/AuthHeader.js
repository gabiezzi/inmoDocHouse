export const AuthHeader = () => {
  const user = JSON.parse(window.localStorage.getItem("user"));
  

  if (user && user.accessToken) {
    return { Authorization: `Bearer ${user.accessToken}` };
  } else {
    return {};
  }
};
