import axios from "axios";

const API_URL = "http://localhost:8080/api/auth/";

const register = (usernamefull, username, email, password) => {
  return axios.post(API_URL + "signup", {
    usernamefull,
    username,
    email,
    password,
  });
};

const login = async (username, password) => {
  const response = await axios
    .post(API_URL + "signin", {
      username,
      password,
    });
  if (response.data.accessToken) {
    localStorage.setItem("user", JSON.stringify(response.data));
  }
  return response.data;
};

const logout = () => {
  localStorage.removeItem("user");
};

export default {
  register,
  login,
  logout,
};
