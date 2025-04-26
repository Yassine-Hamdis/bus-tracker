import { StyleSheet, Text, View, TouchableOpacity, TextInput } from 'react-native';
import React, { useState } from 'react'; // Import useState
import Ionicons from '@expo/vector-icons/Ionicons';
import SimpleLineIcons from '@expo/vector-icons/SimpleLineIcons';
import { Colors } from '../../constants/Colors';
import { useNavigation } from '@react-navigation/native';
import { fonts } from '../../constants/fonts';
import { useRouter } from "expo-router";


const login = () => {
  const navigation = useNavigation();
  const [secureEntery, setSecureEntery] = useState(true); // useState is now properly imported

  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const router = useRouter();

  const handleLogin = async () => {
    try {
      const response = await axios.post('http://localhost:8081/api/auth/login', {
        email,
        password,
      });
      console.log('Token:', response.data.token);
      Alert.alert('Login Successful');
      router.push('/home');
    } catch (error) {
      console.error(error);
      Alert.alert('Login Failed');
    }
  };

  const handleBack = () => {
    navigation.goBack();
  };

  const handleSingup = () => {
    navigation.navigate('singuproot');
  };

  return (
    <View style={styles.container}>
      <TouchableOpacity style={styles.backButtonWrapper} onPress={handleBack}>
        <Ionicons name={"arrow-back-outline"} size={30} color={Colors.primary} />
      </TouchableOpacity>

      <View style={styles.textContainer}>
        <Text style={styles.headingText}>Hey, </Text>
        <Text style={styles.headingText}>Welcome</Text>
        <Text style={styles.headingText}>Back</Text>
      </View>

      <View style={styles.formContainer}>
        <View style={styles.inputContainer}>
          <Ionicons name={"mail-outline"} size={30} color={Colors.secondary} />
          <TextInput
            style={styles.textInput}
            placeholder="Enter your email"
            placeholderTextColor={Colors.secondary}
            keyboardType="email-address"
            value={email} 
            onChangeText={setEmail}
          />
        </View>

        <View style={styles.inputContainer}>
          <SimpleLineIcons name={"lock"} size={30} color={Colors.secondary} />
          <TextInput
            style={styles.textInput}
            placeholder="Enter your password"
            placeholderTextColor={Colors.secondary}
            secureTextEntry={secureEntery}
            value={password} 
            onChangeText={setPassword}
          />
          <TouchableOpacity onPress={() => setSecureEntery((prev) => !prev)}>
            <SimpleLineIcons name={"eye"} size={20} color={Colors.secondary} />
          </TouchableOpacity>
        </View>

        <TouchableOpacity style={styles.loginButtonWrapper} onPress={handleLogin}>
          <Text style={styles.loginText}>Login</Text>
        </TouchableOpacity>

        <View style={styles.footerContainer}>
          <Text style={styles.accountText}>Don't have an account?</Text>
          <TouchableOpacity onPress={handleSingup}>
            <Text style={styles.signupText}>Sign up</Text>
          </TouchableOpacity>
        </View>
      </View>
    </View>
  );
};

export default login;

const styles = StyleSheet.create({
  container: { flex: 1, backgroundColor: Colors.white, padding: 20 },
  backButtonWrapper: {
    height: 40,
    width: 40,
    backgroundColor: Colors.gray,
    borderRadius: 20,
    justifyContent: "center",
    alignItems: "center",
  },
  textContainer: { marginVertical: 20 },
  headingText: { fontSize: 32, color: Colors.primary, fontFamily: fonts.Bold },
  formContainer: { marginTop: 20 },
  inputContainer: {
    borderWidth: 1,
    borderColor: Colors.secondary,
    borderRadius: 100,
    paddingHorizontal: 20,
    flexDirection: "row",
    alignItems: "center",
    padding: 2,
    marginVertical: 10,
  },
  textInput: {
    flex: 1,
    paddingHorizontal: 10,
    fontFamily: "Light",
  },
  loginButtonWrapper: {
    backgroundColor: Colors.primary,
    borderRadius: 100,
    marginTop: 20,
  },
  loginText: {
    color: Colors.white,
    fontSize: 20,
    fontFamily: "Bold",
    textAlign: "center",
    padding: 10,
  },
  footerContainer: {
    flexDirection: "row",
    justifyContent: "center",
    alignItems: "center",
    marginVertical: 20,
    gap: 5,
  },
  accountText: {
    color: Colors.primary,
    fontFamily: "Regular",
  },
  signupText: {
    color: Colors.secondary,
    fontFamily: fonts.Bold,
  },
});