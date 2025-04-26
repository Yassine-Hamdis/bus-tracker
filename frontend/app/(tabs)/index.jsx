import React from "react";
import { createStackNavigator } from "@react-navigation/stack";

import home from "../screens/home";
import login from "../screens/login";
import singupdriver from "../screens/singupdriver";
import singupclient from "../screens/singupclient";
import singuproot from "../screens/singuproot";

const Stack = createStackNavigator();

console.log({ home, login, singupdriver, singupclient, singuproot });

export default function StackNavigator() {
  return (
    <Stack.Navigator screenOptions={{ headerShown: false }}>
      <Stack.Screen name={"home"} component={home} />
      <Stack.Screen name={"singuproot"} component={singuproot} />
      <Stack.Screen name={"login"} component={login} />
      <Stack.Screen name={"singupdriver"} component={singupdriver} />
      <Stack.Screen name={"singupclient"} component={singupclient} />

    </Stack.Navigator>
  );
}